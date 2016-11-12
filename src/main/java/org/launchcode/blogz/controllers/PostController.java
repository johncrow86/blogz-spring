package org.launchcode.blogz.controllers;

import javax.servlet.http.HttpServletRequest;

import org.launchcode.blogz.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController {
	
	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public String newPostGet() {
		return "newpost";
	}
	
	@RequestMapping(value = "/newpost", method = RequestMethod.POST)
	public String newPostPost(HttpServletRequest request, Model model) {
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		
		/*
		 * Need Author
		 */
		String author = "";
		
		boolean hasError = false;
		
		if (title == "" || body == "")
			hasError = true;
		
		if (!(hasError))
			new Post(title, body, author);
		
		return "redirect:signup";
	}
	
}
