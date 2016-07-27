package com.howtodoinjava.demo.controller;

import java.util.List;

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
	@RequestMapping("/addlinks")
	public ModelAndView addlinks(){
		return new ModelAndView("addlinks","command",new Links());
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		Links link = new Links();
		model.addAttribute("Link", link);
		return "addlinks";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String submitLink(@ModelAttribute("Links") Links link, BindingResult result, SessionStatus status) {

		if (result.hasErrors()) {
			return "addlinks";
		}

		LinksDAO.addLink(link);
		// Mark Session Complete
		status.setComplete();
		return "viewLinks";
	}
	@RequestMapping("viewLinks")
	public ModelAndView viewLinks(){

		List <Links> links = LinksDAO.listLinks(); 
		return new ModelAndView("viewLinks", "Links", links);

	}
	
}