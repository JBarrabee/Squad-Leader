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

import javax.servlet.http.HttpServletRequest;

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
	// @RequestParam(value = , )
	// int include = ${selections.include}
	int include = 0;
	String keyWord = "Pluto";
	int limit = 50;

	@RequestMapping("/meetUpMap")

	// Creating the Model and View
	public ModelAndView meetUpMap(Model model, HttpServletRequest servelet)
			throws FileNotFoundException, IOException, ParseException {
		if (servelet.getParameter("include") != null) {
			include = Integer.parseInt(servelet.getParameter("include"));
		}
		if (servelet.getParameter("keyWord") != null) {
			keyWord = servelet.getParameter("keyWord");
		}
		if (servelet.getParameter("limit") != null) {
			limit = Integer.parseInt(servelet.getParameter("limit"));
		}
		// Creating and filling the eventArray
		ArrayList<String> eventURLList = new ArrayList<String>();
		ArrayList<String> descriptionURLList = new ArrayList<String>();
		if (include == 0 || include == 1) {
			eventURLList.add(
					"https://api.meetup.com/ITintheD/events?photo-host=public&page=20&sig_id=209133816&sig=f1f01a0c6faa4c32e47ee45454c2af4d850723de");
		}
		if (!keyWord.equals("Pluto") && (include == 0 || include == 1)) {
			descriptionURLList.add(
					"https://api.meetup.com/ITintheD?photo-host=public&sig_id=209133816&only=description&sig=1305e66cfaa3247e94c63d45d598a7747b709648");
		}
		if (include == 0 || include == 2) {
			eventURLList.add(
					"https://api.meetup.com/refreshdetroit/events?photo-host=public&page=20&sig_id=9283563&sig=182244089349639c68879c73ba06b4d567a867c2");
		}
		if (!keyWord.equals("Pluto") && (include == 0 || include == 2)) {
			descriptionURLList.add(
					"https://api.meetup.com/refreshDetroit?photo-host=public&sig_id=209133816&only=description&sig=ebfeca1f2389e7dc0ace9a2abedb529d6b2674fd");
		}
		if (include == 0 || include == 3) {
			eventURLList.add(
					"https://api.meetup.com/BDPA-Detroit-technology-meetup/events?photo-host=public&page=20&sig_id=209133816&sig=db30a53e119fe9a87011a882d0fb33f1d7120110");
		}
		if (!keyWord.equals("Pluto") && (include == 0 || include == 3)) {
			descriptionURLList.add(
					"https://api.meetup.com/BDPA-Detroit-technology-meetup?photo-host=public&sig_id=209133816&only=description&sig=94c044814bd1f0bfa5777949afd89c78524803b2");
		}
		if (include == 0 || include == 4) {
			eventURLList.add(
					"https://api.meetup.com/Detroit-java-user-group/events?photo-host=public&page=20&sig_id=209133816&sig=1267a5d24e1aac9d58c5f1648f096629783a9517");
		}
		if (!keyWord.equals("Pluto") && (include == 0 || include == 4)) {
			descriptionURLList.add(
					"https://api.meetup.com/Detroit-java-user-group?photo-host=public&sig_id=209133816&only=description&sig=9feccd227ca59d03c316ec8813c9de2ab271c7d9");
		}
		if (include == 0 || include == 5) {
			eventURLList.add(
					"https://api.meetup.com/girl-develop-it-detroit/events?photo-host=public&page=20&sig_id=209133816&sig=a531894ec6e4a1645afb57e9857d08a782203662");
		}
		if (!keyWord.equals("Pluto") && (include == 0 || include == 5)) {
			descriptionURLList.add(
					"https://api.meetup.com/girl-develop-it-detroit?photo-host=public&sig_id=209133816&only=description&sig=5cf899c36a636d58847350f3bf247f30ff6defef");
		}
		if (include == 0 || include == 6) {
			eventURLList.add(
					"https://api.meetup.com/Detroit-User-Experience/events?photo-host=public&page=20&sig_id=209133816&sig=2a2208d5ccbf840bae8af880d717b35569c3088b");
		}
		if (!keyWord.equals("Pluto") && (include == 0 || include == 6)) {
			descriptionURLList.add(
					"https://api.meetup.com/Detroit-User-Experience?photo-host=public&sig_id=209133816&only=description&sig=b750b6ba39bc412377710db9d49372fedbe74229");
		}
		if (include == 0 || include == 7) {
			eventURLList.add(
					"https://api.meetup.com/Great-Lakes-Area-NET-User-Group-MIGANG/events?photo-host=public&page=20&sig_id=209133816&sig=c4d9e411d883061af6ee32c29586206646adec6e");
		}
		if (!keyWord.equals("Pluto") && (include == 0 || include == 7)) {
			descriptionURLList.add(
					"https://api.meetup.com/Great-Lakes-Area-NET-User-Group-MIGANG?photo-host=public&sig_id=209133816&only=description&sig=a2d39d97426b8587735edebfabdb26baa910fd07");
		}
		if (include == 0 || include == 8) {
			eventURLList.add(
					"https://api.meetup.com/TechShopDetroit/events?photo-host=public&page=20&sig_id=209133816&sig=fb1007044b0b014743f8f3b2bdb8b79a62c9b028");
		}
		if (!keyWord.equals("Pluto") && (include == 0 || include == 8)) {
			descriptionURLList.add(
					"https://api.meetup.com/TechShopDetroit?photo-host=public&sig_id=209133816&only=description&sig=5a785f78615af7c06da0d6c4409a691597e4b523");
		}
		if (include == 0 || include == 9) {
			eventURLList.add("https://api.meetup.com/Tech248-Meetup/events?&sign=true&photo-host=public&page=20");
		}
		if (!keyWord.equals("Pluto") && (include == 0 || include == 9)) {
			descriptionURLList.add(
					"https://api.meetup.com/Tech248-Meetup?photo-host=public&sig_id=209133816&only=description&sig=e9085e0debec464fbd506ff587c744440fdb3576");
		}

		// used at bottom Had to keep out of the for loop
		ArrayList<Meetup> eventArray = new ArrayList<Meetup>();
		// Test
		System.out.println("Size of URL list =" + eventURLList.size());
		System.out.println("Size of Description list = " + descriptionURLList.size());
		// need to make sure there is no left over connection

		HttpURLConnection request = null;

		// GETTING THE GROUP DESCRIPTION
		String groupDescription = "";
		// Going through the eventURLList and getting the meetup information
		// from
		// each site
		// FIRST LOOP ON PAGE USE a
		for (int a = 0; a < descriptionURLList.size(); a++) {
			// Connect to the URL using java's native library
			String sURLb = descriptionURLList.get(a);
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
		for (int b = 0; b < eventURLList.size(); b++) {
			// Connect to the URL using java's native library
			String sURLb = eventURLList.get(b);
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

			// Third array use c
			for (int c = 0; c < objArray.size(); c++) {
				Meetup meetup = new Meetup();
				JsonObject eventObject = objArray.get(c).getAsJsonObject();
				JsonObject group = eventObject.get("group").getAsJsonObject();
				String groupURL = group.get("urlname").getAsString();
				String groupName = group.get("name").getAsString();
				String eventName = eventObject.get("name").getAsString();
				String eventLink = eventObject.get("link").getAsString();
				String eventDateString = eventObject.get("time").getAsString();

				String shortString = eventDateString.substring(0, eventDateString.length() - 4);
				Long eventDateLong = Long.parseLong(eventDateString);

				int eventDateInt = Integer.parseInt(shortString);
				// Need to change the formatting of the Epoc Time.
				// Epoc time should be helpful for sorting
				DateFormat format = new SimpleDateFormat("EEEE MMM dd, h:mm a");
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
				meetup.setEVENT_LINK(eventLink);
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
		model.addAttribute("limit", limit);
		return new ModelAndView("meetUpMap");
	}
	// Could we create a different Model and view to send to send to the Maps?
	// How would we get the information from here to the Map Controller?
	// @RequestMapping("/StudentMap");

	// Creating the Model and View
	// public ModelAndView meetUpMap(Model model, HttpServletRequest servelet)
	// throws FileNotFoundException, IOException, ParseException {
	// model.addAttribute("EventList", eventArray);
	// return new ModelAndView("StudentMap");
	// }
}
