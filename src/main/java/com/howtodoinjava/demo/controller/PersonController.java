package com.howtodoinjava.demo.controller;

import net.squadleader.people.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.howtodoinjava.demo.service.EmployeeManager;
import com.howtodoinjava.demo.validator.EmployeeValidator;

@Controller
@RequestMapping("addPerson")
@SessionAttributes("person")
public class PersonController 
{
	@Autowired
	EmployeeManager manager;
	
	@Autowired
	EmployeeValidator validator;
	
	@RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model) 
	{
		 Person person = new Person();
		 model.addAttribute("person", person);
		 return "addPerson";
    }
	
	
	
	@RequestMapping(method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("person") Person person,
            				BindingResult result, SessionStatus status) 
	{
		
		validator.validate(person, result);
		
		if (result.hasErrors()) {
			return "addPerson";
		}
		//Store the employee information in database
		//manager.createNewRecord(Person);
		PeopleDAO.addPerson(person);
		//Mark Session Complete
		status.setComplete();
		return "addSuccess";
    }
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success(Model model) 
	{
		 return "addSuccess";
    }
}