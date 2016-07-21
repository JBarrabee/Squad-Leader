package com.howtodoinjava.demo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.squadleader.people.PeopleDAO;
import net.squadleader.people.Person;

@Controller
public class LoginController {
	@RequestMapping("/submitLogin")
	public String submitLogin(@ModelAttribute("command") Person person, Model model, @CookieValue(value = "loggedIn", defaultValue="false") String loggedIn, HttpServletResponse response){
		if (PeopleDAO.checkLogin(person)){
			Cookie cookie = new Cookie("loggedIn","true");
			cookie.setMaxAge(60);
			response.addCookie(cookie);
			model.addAttribute("cookie", cookie);
			return "addSuccess";
		} else {
			if (PeopleDAO.containsPerson(person))
				model.addAttribute("passError", "Password is incorrect");
			else
				model.addAttribute("userError", "User doesn't exist");
			return "login";		
		}
	}
	@RequestMapping("/createLogin")
	public ModelAndView createLogin() {
		return new ModelAndView("login", "command", new Person());
	}
}
