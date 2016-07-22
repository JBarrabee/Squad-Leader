package com.howtodoinjava.demo.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller

public class mapController {
	
	@RequestMapping("StudentMap")

	public String map( Model model)
			throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();
		
		String address = "484 brainard St. Detroit, MI 48201";
		String encodedAddress = URLEncoder.encode(address, "UTF-8");

		// get json object from geocode api for user location
		String url = "https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyDH6PNEja-Sh-fhKEmuMDnYWlcpaDbCPBg&address="
				+ encodedAddress;
		
		
		HttpClient client = HttpClientBuilder.create().build();

		HttpGet request = new HttpGet(url);

		HttpResponse response = client.execute(request);

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line.trim());

		}

		request.releaseConnection();

		JsonElement jelement = new JsonParser().parse(result.toString());

		JsonObject jObject = jelement.getAsJsonObject();
		
		jObject = jObject.getAsJsonObject();
		
		JsonArray jArray = jObject.getAsJsonArray("results");
		jObject = jArray.get(0).getAsJsonObject();
		jObject = jObject.getAsJsonObject("geometry");
		jObject = jObject.getAsJsonObject("location");
		String lat = jObject.get("lat").getAsString();
		String lng = jObject.get("lng").getAsString();
		
		
		
		 String myHouse = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?key=AIzaSyDH6PNEja-Sh-fhKEmuMDnYWlcpaDbCPBg&location="
				+ lat + "," + lng ;

		 model.addAttribute("location", );
		
		System.out.println(myHouse);
		return "StudentMap";
	}
	
	

}
