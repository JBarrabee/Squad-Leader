package com.howtodoinjava.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import net.squadleader.links.Links;
import net.squadleader.links.LinksDAO;
import net.squadleader.people.Person;

@Controller
public class LinkController {
	String category;
	@RequestMapping("/addlinks")
	public ModelAndView addlinks(){
		return new ModelAndView("addlinks","command",new Links());
	}

	@RequestMapping("/submitLink")
	public ModelAndView submitLink(@ModelAttribute("link") Links link, BindingResult result, SessionStatus status) {

		if (result.hasErrors()) {
			return new ModelAndView("addlinks","command",new Links());

		}

		LinksDAO.addLink(link);
		// Mark Session Complete
		status.setComplete();
		
		List <Links> LinksList = LinksDAO.listLinks(); 
		return new ModelAndView("viewLinks", "Link", LinksList);
	}
	@RequestMapping("viewLinks")

	public ModelAndView viewLinks(HttpServletRequest servlet){
		List <Links> LinksList = LinksDAO.listLinks(); 
//		
//		if (servlet.getParameter("categories") != null)
//			category = servlet.getParameter("category");
//			if (category.equalsIgnoreCase("SQL") || category.equalsIgnoreCase("all"))
//				LinksList.add
				
		
		return new ModelAndView("viewLinks", "Link", LinksList);

	}
	
}