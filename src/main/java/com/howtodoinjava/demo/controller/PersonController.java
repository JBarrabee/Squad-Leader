package com.howtodoinjava.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.howtodoinjava.demo.service.EmployeeManager;
import com.howtodoinjava.demo.validator.EmployeeValidator;

import net.squadleader.people.PeopleDAO;
import net.squadleader.people.Person;

@Controller
@RequestMapping("addPerson")
@SessionAttributes("person")
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
		model.addAttribute("person", person);
		return "addPerson";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("person") Person person, BindingResult result, SessionStatus status) {

		validator.validate(person, result);

		if (result.hasErrors()) {
			return "addPerson";
		}

		System.out.println(person.getDOB());
		System.out.println(person.getDOB().toString());
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

