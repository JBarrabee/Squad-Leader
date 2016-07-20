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
public class PersonController 
{
	@Autowired
	EmployeeManager manager;
	
	@Autowired
	EmployeeValidator validator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
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
	
	@RequestMapping("/createLogin")
 	public ModelAndView createLogin() {
 		return new ModelAndView("login", "command", new Person());
  	}


	@RequestMapping("/submitLogin")
	public String submitLogin(@ModelAttribute("command") Person person, Model model, @CookieValue(value = "loggedIn", defaultValue="false") String loggedIn, HttpServletResponse response){
		if (PeopleDAO.checkLogin(person)){
			Cookie cookie = new Cookie("loggedIn","true");
			cookie.setMaxAge(60);
			response.addCookie(cookie);
			model.addAttribute("cookie", cookie);
			return "memberArea";
		} else {
			if (PeopleDAO.containsPerson(person))
				model.addAttribute("passError", "Password is incorrect");
			else
				model.addAttribute("userError", "User doesn't exist");
			
			return "login";
				
		}
	}
}