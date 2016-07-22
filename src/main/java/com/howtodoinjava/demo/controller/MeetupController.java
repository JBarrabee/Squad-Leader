package com.howtodoinjava.demo.controller;

import net.squadleader.meetups.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.google.gson.JsonArray;

import com.howtodoinjava.demo.service.EmployeeManager;
import com.howtodoinjava.demo.validator.EmployeeValidator;

import antlr.collections.List;

@Controller
// This is what the index page needs to ask for in the URL

public class MeetupController {

	@RequestMapping("/meetUpMap")

	// Meetup meetup = new Meetup();
	// model.addAttribute("meetup", meetup);

	public ModelAndView meetUpMap(Model model) throws FileNotFoundException, IOException, ParseException {

		ArrayList<String> URLList = new ArrayList<String>();
		URLList.add(
				"https://api.meetup.com/ITintheD/events?photo-host=public&page=20&sig_id=209133816&sig=f1f01a0c6faa4c32e47ee45454c2af4d850723de");
		URLList.add(
				"https://api.meetup.com/refreshdetroit/events?photo-host=public&page=20&sig_id=9283563&sig=182244089349639c68879c73ba06b4d567a867c2");
		URLList.add(
				"https://api.meetup.com/BDPA-Detroit-technology-meetup/events?photo-host=public&page=20&sig_id=209133816&sig=db30a53e119fe9a87011a882d0fb33f1d7120110");
		URLList.add(
				"https://api.meetup.com/Detroit-java-user-group/events?photo-host=public&page=20&sig_id=209133816&sig=1267a5d24e1aac9d58c5f1648f096629783a9517");
		URLList.add(
				"https://api.meetup.com/girl-develop-it-detroit/events?photo-host=public&page=20&sig_id=209133816&sig=a531894ec6e4a1645afb57e9857d08a782203662");
		URLList.add(
				"https://api.meetup.com/the-iron-yard-detroit/events?photo-host=public&page=20&sig_id=209133816&sig=54e41552a1621655091dd3aab3b543e075b0f0b6");

		ArrayList<Meetup> eventArray = new ArrayList<Meetup>();
		// used at bottom

		System.out.println(URLList.size());

		HttpURLConnection request = null;

		for (int b = 0; b < URLList.size(); b++) {
			// Connect to the URL using java's native library
			String sURLb = URLList.get(b);
			URL url = new URL(sURLb);
			request = (HttpURLConnection) url.openConnection();
			request.connect();

			// Convert to a JSON object to print data
			JsonParser jp = new JsonParser(); // from gson
			JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
			// Convert the input stream to a jsonelement
			JsonArray objArray = root.getAsJsonArray(); // May be an array,
														// may be an object.
			System.out.println("stage2");
			System.out.println("Object Array Size = " + objArray.size());

			for (int a = 0; a < objArray.size(); a++) {
				Meetup meetup = new Meetup();
				JsonObject firstObject = objArray.get(a).getAsJsonObject();
				JsonObject group = firstObject.get("group").getAsJsonObject();
				String groupURL = group.get("urlname").getAsString();
				String groupName = group.get("name").getAsString();

				String eventName = firstObject.get("name").getAsString();
				String eventTime = firstObject.get("time").getAsString();

				DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				String formattedDate = format.format(Integer.parseInt(eventTime));

				System.out.println(formattedDate);

				JsonObject venue = firstObject.get("venue").getAsJsonObject();
				String venueName = venue.get("name").getAsString();
				String eventStreet = venue.get("address_1").getAsString();
				String eventCity = venue.get("city").getAsString();
				String eventState = venue.get("state").getAsString();
				String eventZIP = venue.get("zip").getAsString();
				String eventLatitude = venue.get("lat").getAsString();
				String eventLongitude = venue.get("lon").getAsString();

				meetup.setGROUP_URL(groupURL);
				meetup.setGROUP_NAME(groupName);
				meetup.setEVENT_DATE(formattedDate);
				meetup.setEVENT_VENUE_NAME(venueName);
				meetup.setEVENT_STREET(eventStreet);
				meetup.setEVENT_CITY(eventCity);
				meetup.setEVENT_DATE(eventTime);
				meetup.setEVENT_STATE(eventState);
				meetup.setEVENT_ZIP(eventZIP);
				meetup.setEVENT_LATITUDE(eventLatitude);
				meetup.setEVENT_LONGITUDE(eventLongitude);
				meetup.setEVENT_NAME(eventName);

				eventArray.add(meetup);
			}
		}

		model.addAttribute("EventList", eventArray);
		return new ModelAndView("meetUpMap");

	}

	public static void main(String[] args) {
		Model a = new BindingAwareModelMap();
		MeetupController s = new MeetupController();
		try {
			s.meetUpMap(a);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
