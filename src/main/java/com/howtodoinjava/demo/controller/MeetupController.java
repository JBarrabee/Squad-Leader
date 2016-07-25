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
import java.util.Collections;
import java.util.Comparator;

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
	int include = 0;
	int limit = 10;
	String keyWord = "electronics";

	@RequestMapping("/meetUpMap")

	// Creating the Model and View
	public ModelAndView meetUpMap(Model model) throws FileNotFoundException, IOException, ParseException {

		// Creating and filling the ArrayList, Going to put in if statements
		ArrayList<String> URLList = new ArrayList<String>();
		ArrayList<String> descriptionList = new ArrayList<String>();
		if (include == 0 || include == 1) {
			URLList.add(
					"https://api.meetup.com/ITintheD/events?photo-host=public&page=20&sig_id=209133816&sig=f1f01a0c6faa4c32e47ee45454c2af4d850723de");
		}
		// Adding events to the list to be searched for a key word.
		if (include == 0 || include == 1) {
			descriptionList.add(
					"https://api.meetup.com/ITintheD?photo-host=public&sig_id=209133816&only=description&sig=1305e66cfaa3247e94c63d45d598a7747b709648");
		}
		if (include == 0 || include == 2) {
			URLList.add(
					"https://api.meetup.com/refreshdetroit/events?photo-host=public&page=20&sig_id=9283563&sig=182244089349639c68879c73ba06b4d567a867c2");
		}
		if (include == 0 || include == 2) {
			descriptionList.add(
					"https://api.meetup.com/refreshDetroit?photo-host=public&sig_id=209133816&only=description&sig=ebfeca1f2389e7dc0ace9a2abedb529d6b2674fd");
		}
		if (include == 0 || include == 3) {
			URLList.add(
					"https://api.meetup.com/BDPA-Detroit-technology-meetup/events?photo-host=public&page=20&sig_id=209133816&sig=db30a53e119fe9a87011a882d0fb33f1d7120110");
		}
		if (include == 0 || include == 4) {
			URLList.add(
					"https://api.meetup.com/Detroit-java-user-group/events?photo-host=public&page=20&sig_id=209133816&sig=1267a5d24e1aac9d58c5f1648f096629783a9517");
		}
		if (include == 0 || include == 5) {
			URLList.add(
					"https://api.meetup.com/girl-develop-it-detroit/events?photo-host=public&page=20&sig_id=209133816&sig=a531894ec6e4a1645afb57e9857d08a782203662");
		}
		if (include == 0 || include == 6) {
			URLList.add(
					"https://api.meetup.com/Detroit-User-Experience/events?photo-host=public&page=20&sig_id=209133816&sig=2a2208d5ccbf840bae8af880d717b35569c3088b");
		}
		if (include == 0 || include == 7) {
			URLList.add(
					"https://api.meetup.com/Great-Lakes-Area-NET-User-Group-MIGANG/events?photo-host=public&page=20&sig_id=209133816&sig=c4d9e411d883061af6ee32c29586206646adec6e");
		}
		if (include == 0 || include == 8) {
			URLList.add(
					"https://api.meetup.com/TechShopDetroit/events?photo-host=public&page=20&sig_id=209133816&sig=fb1007044b0b014743f8f3b2bdb8b79a62c9b028");
		}
		if (include == 0 || include == 9) {
			URLList.add("https://api.meetup.com/Tech248-Meetup/events?&sign=true&photo-host=public&page=20");
		}

		// used at bottom Had to keep out of the for loop
		ArrayList<Meetup> eventArray = new ArrayList<Meetup>();
		// Test
		System.out.println("Size of URL list =" + URLList.size());
		System.out.println("Size of Description list = " + descriptionList.size());
		// need to make sure there is no left over connection

		HttpURLConnection request = null;
		// Going through the URLList and getting the meetup information from
		// each site

		// GETTING THE GROUP DESCRIPTION

		String groupDescription = "";
		// Going through the URLList and getting the meetup information from
		// each site
		// FIRST LOOP ON PAGE USE a
		for (int a = 0; a < descriptionList.size(); a++) {
			// Connect to the URL using java's native library
			String sURLb = descriptionList.get(a);
			URL url = new URL(sURLb);
			// Getting the connection
			request = (HttpURLConnection) url.openConnection();
			request.connect();

			// Create the object jp, JsonParser is from gson
			JsonParser jp = new JsonParser(); // using the reader to take out
												// the info from the reader
			JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
			// Convert the input stream to a jsonArray
			JsonObject descriptionObject = root.getAsJsonObject();

			// JsonObject descriptionObject = objArray.getAsJsonObject();
			groupDescription = descriptionObject.get("description").getAsString();
			System.out.println(groupDescription);
		}
		// GETTING EVENT DISTRACTION

		HttpURLConnection request2 = null;
		// Second Array use b
		for (int b = 0; b < URLList.size(); b++) {
			// Connect to the URL using java's native library
			String sURLb = URLList.get(b);
			URL url = new URL(sURLb);
			// Getting the connection
			request2 = (HttpURLConnection) url.openConnection();
			request2.connect();

			// Create the object jp, JsonParser is from gson
			JsonParser jp = new JsonParser();
			// using the reader to take out the info from the reader
			JsonElement root = jp.parse(new InputStreamReader((InputStream) request2.getContent()));
			// Convert the input stream to a jsonArray
			JsonArray objArray = root.getAsJsonArray();
			// Test
			System.out.println("stage2");
			System.out.println("Object Array Size = " + objArray.size());
			// the array may have several events each of which is an array.
			// there are variables and there are also objects with variables
			// group and venue are objects
			// Inner loop taking apart the JsonArray with getters and saving
			// elements as strings

			// LIMIT SIZE
			// number just needs to be initialized
			int number = 0;
			if (objArray.size() < limit)
				number = objArray.size();
			else
				number = limit;
			// Third array use c
			for (int c = 0; c < number; c++) {
				Meetup meetup = new Meetup();
				JsonObject eventObject = objArray.get(c).getAsJsonObject();
				JsonObject group = eventObject.get("group").getAsJsonObject();
				String groupURL = group.get("urlname").getAsString();
				String groupName = group.get("name").getAsString();
				String eventName = eventObject.get("name").getAsString();

				String eventDateString = eventObject.get("time").getAsString();
				String shortString = eventDateString.substring(0, eventDateString.length() - 4);
				Long eventDateLong = Long.parseLong(eventDateString);

				int eventDateInt = Integer.parseInt(shortString);
				// Need to change the formatting of the Epoc Time.
				// Epoc time should be helpful for sorting
				DateFormat format = new SimpleDateFormat("EEEE MMM dd, yyyy h:mm a");
				String formattedDate = format.format(eventDateLong);

				// Test
				System.out.println(formattedDate + " " + eventName);

				JsonObject venue = eventObject.get("venue").getAsJsonObject();
				String venueName = venue.get("name").getAsString();
				String eventStreet = venue.get("address_1").getAsString();
				String eventCity = venue.get("city").getAsString();
				String eventState = venue.get("state").getAsString();
				String eventZIP = venue.get("zip").getAsString();
				String eventLatitude = venue.get("lat").getAsString();
				String eventLongitude = venue.get("lon").getAsString();
				String eventDescription = eventObject.get("description").getAsString();
				System.out.println(eventDescription);
				// Loading all the variables into the object meetup
				meetup.setGROUP_URL(groupURL);
				meetup.setGROUP_NAME(groupName);
				meetup.setEVENT_NAME(eventName);
				meetup.setEVENT_DATE(formattedDate);
				meetup.setEVENT_DATE_INT(eventDateInt);
				meetup.setEVENT_VENUE_NAME(venueName);
				meetup.setEVENT_STREET(eventStreet);
				meetup.setEVENT_CITY(eventCity);
				meetup.setEVENT_STATE(eventState);
				meetup.setEVENT_ZIP(eventZIP);
				meetup.setEVENT_LATITUDE(eventLatitude);
				meetup.setEVENT_LONGITUDE(eventLongitude);
				meetup.setGROUP_DESCRIPTION(groupDescription);
				meetup.setEVENT_DESCRIPTION(eventDescription);

				if (groupDescription.toLowerCase().contains(keyWord.toLowerCase())
						|| eventDescription.toLowerCase().contains(keyWord.toLowerCase())) {
					// putting the meetup in an array to be sent to another
					// screen
					eventArray.add(meetup);
				} else {
					continue;
				}
			}
		}
		// This is the part where the method to put the meetups in order is
		// created.
		Comparator<Meetup> comparator = new Comparator<Meetup>() {

			public int compare(Meetup m1, Meetup m2) {
				return (m1.getEVENT_DATE_INT() - m2.getEVENT_DATE_INT());
			}
		};
		// this is using the above method to sort.
		Collections.sort(eventArray, comparator);

		// This is the test.
		System.out.println("==========");
		for (Meetup meetup : eventArray) {
			System.out
					.println(meetup.getEVENT_DATE() + "---" + meetup.getGROUP_NAME() + "---" + meetup.getEVENT_NAME());
		}
		// This is where the eventList is packaged for sending
		model.addAttribute("EventList", eventArray);
		return new ModelAndView("meetUpMap");
	}

	// Bellow is what is necessary to run the tests.
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
