package com.howtodoinjava.demo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import net.squadleader.people.PeopleDAO;
import net.squadleader.people.Person;

@Controller
//@SessionAttributes("loggedIn")
public class LoginController {
	@RequestMapping("/submitLogin")
	public String submitLogin(@ModelAttribute("command") Person person, Model model, @CookieValue(value = "loggedIn", defaultValue="false") String loggedIn,
			HttpServletResponse response, HttpServletRequest request){
		if (PeopleDAO.checkLogin(person)){
			Cookie cookie = new Cookie("loggedIn","true");
			cookie.setMaxAge(60);
			response.addCookie(cookie);
			//model.addAttribute("cookie", cookie);
	//		HttpSession session = request.getSession();
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
	public ModelAndView createLogin(HttpServletResponse response, @CookieValue(value="loggedIn", defaultValue="false")String cookie) {
		if(cookie.equalsIgnoreCase("false")){
			return new ModelAndView("login", "command", new Person());
		}else{
			return new ModelAndView("addSuccess");
		}
	}
	
	@RequestMapping("/Logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, @CookieValue(value="loggedIn")String cookie){
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cook: cookies) {
				if (cook.getName().equals("loggedIn")){
					cook.setMaxAge(0);
					cook.setValue("false");
					response.addCookie(cook);
				}
			}	
		}
		return new ModelAndView("login", "command", new Person());
	}
	
	@RequestMapping("/addSuccess")
	public ModelAndView addSuccess(HttpServletRequest request, @CookieValue(value="loggedIn", defaultValue="false")String cookie){

		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cook: cookies) {
				//If there is a cookie named loggedIn & its value is equal to true take you to "member area" - addSuccess.
				if (cook.getName().equals("loggedIn") && cook.getValue().equals("true"))
					return new ModelAndView("addSuccess");
			}
		}
		return new ModelAndView("login", "command", new Person());
		
	}
	
}
