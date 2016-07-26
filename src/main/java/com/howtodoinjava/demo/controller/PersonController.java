package com.howtodoinjava.demo.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.howtodoinjava.demo.service.EmployeeManager;
import com.howtodoinjava.demo.validator.EmployeeValidator;

import net.squadleader.people.PeopleDAO;
import net.squadleader.people.Person;

@Controller
@RequestMapping("addPerson")
@SessionAttributes("Person")
public class PersonController {
	@Autowired
	EmployeeManager manager;

	@Autowired
	EmployeeValidator validator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		Person person = new Person();
		model.addAttribute("Person", person);
		return "addPerson";
	}

	@RequestMapping(method = RequestMethod.POST)

	public String submitForm(@ModelAttribute("Person") Person person, Model model, BindingResult result, SessionStatus status)

			throws FileNotFoundException, IOException, ParseException{
	
//validates user input
		validator.validate(person, result);
		
		if (PeopleDAO.containsPerson(person))
			model.addAttribute("userExistError", "An account associated with this e-mail address already exists.");

		if (result.hasErrors()) {
			return "addPerson";
		}
//pulls latlng from google geocoder	
		JSONParser parser = new JSONParser();
		
		String ADDRESS = person.getSTREET_ADDRESS() + person.getCITY() + person.getSTATE();
		String encodedAddress = URLEncoder.encode(ADDRESS, "UTF-8");
		
		String url = "https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyDH6PNEja-Sh-fhKEmuMDnYWlcpaDbCPBg&address="
				+ encodedAddress;
		
		HttpClient client = HttpClientBuilder.create().build();
		

		HttpGet request = new HttpGet(url);

		HttpResponse response = client.execute(request);

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		
		String line, json="";
		while ((line = rd.readLine()) != null){
			json += line;
		}
		System.out.println(json);
		request.releaseConnection();
		
		JsonElement jelement = new JsonParser().parse(json.toString());

		JsonObject jObject = jelement.getAsJsonObject();
		
		jObject = jObject.getAsJsonObject();
		
		JsonArray jArray = jObject.getAsJsonArray("results");
		jObject = jArray.get(0).getAsJsonObject();
		jObject = jObject.getAsJsonObject("geometry");
		jObject = jObject.getAsJsonObject("location");
		String LAT = jObject.get("lat").getAsString();
		String LNG = jObject.get("lng").getAsString();
		
		person.setLAT(LAT);
		person.setLNG(LNG);
		
		// Store the employee information in database
		// manager.createNewRecord(Person);

		PeopleDAO.addPerson(person);
		// Mark Session Complete
		status.setComplete();
		return "addSuccess";
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)

	public String success(Model model) {
		return "addSuccess";
		
	
	}
}

