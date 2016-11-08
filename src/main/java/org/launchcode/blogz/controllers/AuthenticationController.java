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
		
		if (!(User.isValidUsername(username)))
			hasError = true;
			
	}
	
}
