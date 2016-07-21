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
@RequestMapping("addMeetup")
@SessionAttributes("meetup")
public class MeetupController {

//	public ModelAndView listEvents()
//	{
//	
//	ArrayList <String> meetupArray = new ArrayList <String> (); 
//	meetupArray.add("https://api.meetup.com/ITintheD/events?photo-host=public&page=20&sig_id=209133816&sig=f1f01a0c6faa4c32e47ee45454c2af4d850723de");
//	meetupArray.add("https://api.meetup.com/refreshdetroit/events?photo-host=public&page=20&sig_id=9283563&sig=182244089349639c68879c73ba06b4d567a867c2");
//	meetupArray.add("https://api.meetup.com/BDPA-Detroit-technology-meetup/events?photo-host=public&page=20&sig_id=209133816&sig=db30a53e119fe9a87011a882d0fb33f1d7120110");	
//	meetupArray.add("https://api.meetup.com/Detroit-java-user-group/events?photo-host=public&page=20&sig_id=209133816&sig=1267a5d24e1aac9d58c5f1648f096629783a9517");
//	meetupArray.add("https://api.meetup.com/girl-develop-it-detroit/events?photo-host=public&page=20&sig_id=209133816&sig=a531894ec6e4a1645afb57e9857d08a782203662");	
//	meetupArray.add("https://api.meetup.com/the-iron-yard-detroit/events?photo-host=public&page=20&sig_id=209133816&sig=54e41552a1621655091dd3aab3b543e075b0f0b6");
//
//	for (int i = 0; i<meetupArray.size(); i++){
//		//from Java Script for proof.  Not needed
//	/*String a = "list";
//		String c = Integer.toString(i);
//		String list = a.concat(c);
//		String link = meetupArray.get(i);
//		loadDoc(list , link )*/
//	
//	String sURL = meetupArray.get(i);//just a string
//	
//	HttpURLConnection request = null;
//	try {
//	    // Connect to the URL using java's native library
//	    URL url = new URL(sURL);
//	    request = (HttpURLConnection) url.openConnection();
//	    request.connect();
//
//	    // Convert to a JSON object to print data
//	   JsonParser jp = new JsonParser(); //from gson
//	    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
//	    JsonArray objArray = root.getAsJsonArray(); //May be an array, may be an object.   
//	    
//	    for (i = 0; i < objArray.size(); i++) {
//    		(if objArray.get(i).equals("name").;
//    			for(int a = 0; a< )
//    			if(firstEvent.get.equals("name")){
//    			System.out.println (name)}
//    			}
//    				getAsString();
//    		
//    		
//    		ArrayList<String> firstEventArray = new ArrayList<String>(Arrays.asList(firstEvent.split(",")));
//	    	String EVENT_ID = objArray.getJsonObject(i).getJSONString("id");
//    		var GROUP_URL = rootObj[i].group.urlname;
//    		var GROUP_NAME = jsonObj[i].group.name;
//			var EVENT_NAME = jsonObj[i].name;
//			//Not sure where the new came from
//			//var EVENT_DATE = new Date(jsonObj[i].time).customFormat("");
//			var EVENT_DATE = jsonObj[i].time;
//			var EVENT_VENUE_NAME = jsonObj[i].venue.name;
//			var EVENT_STREET = jsonObj[i].venue.address_1;
//			var EVENT_CITY= jsonObj[i].venue.city;
//			var EVENT_STATE= jsonObj[i].venue.state;
//			var EVENT_ZIP = jsonObj[i].venue.zip;
//			var EVENT_LATITUDE = jsonObj[i].venue.lat;
//			var EVENT_LONGITUDE = jsonObj[i].venue.lon;
//			var EVENT_LINK = jsonObj[i].link;
//			
//			var meetup = { EVENT_ID, GROUP_URL, GROUP_NAME, EVENT_NAME, EVENT_DATE,
//					EVENT_VENUE_NAME, EVENT_STREET, EVENT_ZIP, EVENT_LATITUDE, 
//					EVENT_LONGITUDE, EVENT_LINK };
//					
//			var eventArray = [];
//			eventArray.push(meetup)
//	    }
//	    
//	    
//	    
//	    
//	    
//	    
//	    
//	    
//	    
//	    
//	    return new 
//				ModelAndView("shuffle","message", rootobj);
//	} catch (Exception e ) {
//		 return new 
//				ModelAndView("error","message", "HTTP Connection Error: " + e);
//	} finally {
//		if (request != null)
//			request.disconnect();
//	}
//	
//	
//	
//	}
//
//	}
//
//	@Autowired
//	EmployeeManager manager;
//
//	@Autowired
//	EmployeeValidator validator;
//
//	@RequestMapping(method = RequestMethod.GET)
//	public String setupForm(Model model) {
//		Meetup meetup = new Meetup();
//		model.addAttribute("meetup", meetup);
//		return "addMeetup";
//	}
//
//	@RequestMapping(method = RequestMethod.POST)
//	public String submitForm(@ModelAttribute("meetup") Meetup meetup, BindingResult result, SessionStatus status) {
//
//		validator.validate(meetup, result);
//
//		if (result.hasErrors()) {
//			return "addMeetup";
//		}
//		// Store the employee information in database
//		// manager.createNewRecord(Person);
//		MeetupsDAO.addMeetup(meetup);
//		// Mark Session Complete
//		status.setComplete();
//		return "addSuccess";
//	}
//
//	@RequestMapping(value = "/success", method = RequestMethod.GET)
//	public String success(Model model) {
//		return "addSuccess";
//	}
//}
}