package org.launchcode.blogz.controllers;

import javax.servlet.http.HttpServletRequest;

import org.launchcode.blogz.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthenticationController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/loggin", method = RequestMethod.POST)
	public String loginPost() {
		
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupForm() {
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(HttpServletRequest request, Model model) {
		
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
		
		if (!(hasError)) {
			new User(username, password);
		}
		
		return "redirect:signup";
		
	}
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String success() {
		return "success";
	}
	
}
