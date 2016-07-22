package com.howtodoinjava.demo.controller;

import net.squadleader.meetups.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
// @SessionAttributes("meetup")
//
public class MeetupController {

	@RequestMapping("/MeetupController")
	public ModelAndView listEvents() {

		ArrayList<String> meetupArray = new ArrayList<String>();
		meetupArray.add(
				"https://api.meetup.com/ITintheD/events?photo-host=public&page=20&sig_id=209133816&sig=f1f01a0c6faa4c32e47ee45454c2af4d850723de");
		meetupArray.add(
				"https://api.meetup.com/refreshdetroit/events?photo-host=public&page=20&sig_id=9283563&sig=182244089349639c68879c73ba06b4d567a867c2");
		meetupArray.add(
				"https://api.meetup.com/BDPA-Detroit-technology-meetup/events?photo-host=public&page=20&sig_id=209133816&sig=db30a53e119fe9a87011a882d0fb33f1d7120110");
		meetupArray.add(
				"https://api.meetup.com/Detroit-java-user-group/events?photo-host=public&page=20&sig_id=209133816&sig=1267a5d24e1aac9d58c5f1648f096629783a9517");
		meetupArray.add(
				"https://api.meetup.com/girl-develop-it-detroit/events?photo-host=public&page=20&sig_id=209133816&sig=a531894ec6e4a1645afb57e9857d08a782203662");
		meetupArray.add(
				"https://api.meetup.com/the-iron-yard-detroit/events?photo-host=public&page=20&sig_id=209133816&sig=54e41552a1621655091dd3aab3b543e075b0f0b6");

		ArrayList<Meetup> eventArray = new ArrayList<Meetup>();
		// used at bottom
		ArrayList<String> sURLList = new ArrayList<String>();

		System.out.println(meetupArray.size());

		for (int i = 0; i < meetupArray.size(); i++) {

			String sURL = meetupArray.get(i);// just a string
			// System.out.println(sURL);
			sURLList.add(sURL);

		}

		HttpURLConnection request = null;
		try {

			ModelAndView mv = new ModelAndView("viewEvents");
			for (int b = 0; b < sURLList.size(); b++) {
				// Connect to the URL using java's native library
				String sURLb = sURLList.get(b);
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
					meetup.setEVENT_VENUE_NAME(venueName);
					meetup.setEVENT_STREET(eventStreet);
					meetup.setEVENT_CITY(eventCity);
					meetup.setEVENT_STATE(eventState);
					meetup.setEVENT_ZIP(eventZIP);
					meetup.setEVENT_LATITUDE(eventLatitude);
					meetup.setEVENT_LONGITUDE(eventLongitude);
					meetup.setEVENT_NAME(eventName);

					eventArray.add(meetup);

					// System.out.println(
					// "Event Name = " + eventArray.get(0).getEVENT_NAME() +
					// "rt" + "Venue Name = " + venueName);

					// String mvObjectName = eventCity;
					// System.out.println("EventCity = " + mvObjectName);

					// mv.addObject takes String Attribute Name, Object
					// Attribute Value
					// mv.getView() returns the View Object
					// mv.getViewName() only returns the location to be sent
					System.out.println("Event Names = " + eventArray.get(a).getEVENT_NAME());
					// System.out.println(groupName + " " + a);

				}

			}
			mv.addObject("eventArray", eventArray);
			// mv.setViewName();
			int q = 0;
			for (Meetup p : eventArray) {
				String event = p.getEVENT_NAME();
				q = q++;
				System.out.println("Number # " + q + "event name = " + event);
			}
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("error", "message", "HTTP Connection Error: " + e);
		} finally {
			if (request != null)
				request.disconnect();
		}

		// return null would not work if we put url connection inside a loop
		// return null;
	}
}
/*
 * public static void main(String[] args) { listEvents();
 * System.out.println("Worked?"); }
 */

/*
 * return new ModelAndView("shuffle","message", rootobj); } catch (Exception e )
 * { return new ModelAndView("error","message", "HTTP Connection Error: " + e);
 * } finally { if (request != null) request.disconnect(); }
 * 
 * 
 * 
 * }
 * 
 * }
 * 
 * @Autowired EmployeeManager manager;
 * 
 * @Autowired EmployeeValidator validator;
 */
