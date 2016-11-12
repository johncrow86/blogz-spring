package org.launchcode.blogz.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.launchcode.blogz.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthenticationController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
		return "redirect:login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(HttpServletRequest request, HttpServletResponse response) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (User.doesExist(username)) {
			/*
			 * Get User
			 */
		}
		
		/*
		 * Add Cookie Functionality
		 */
		Cookie myCookie = new Cookie("name", "val");
		response.addCookie(myCookie);
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupForm() {
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(HttpServletRequest request, Model model) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String verify = request.getParameter("verify");
		String email = request.getParameter("email");
		
		boolean hasError = false;
		String error = "";
		
		if (!(User.isValidUsername(username))) {
			hasError = true;
			error = "Invalid username";
		} else if (User.doesExist(username)) {
			hasError = true;
			error = "User already exists";
		} else if (!(password.equals(verify))) {
			hasError = true;
			error = "Passwords do not match";
		}
		
		if (!(hasError))
			new User(username, password);
		
		return "redirect:signup";
		
	}
	
}
