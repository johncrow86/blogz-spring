package org.launchcode.blogz.models;

import java.util.Date;

public class Post extends Entity {

	private String title;
	private String body;
	private String author;
	private final Date created;
	private Date modified;
	
	public Post(String title, String body, String author) {
		super();
		this.title = title;
		this.body = body;
		this.author = author;
		created = new Date();
	}
	
	public void editTitle(String title) {
		this.title = title;
		modified = new Date();
	}
	
	public void editBody(String body) {
		this.body = body;
		modified = new Date();
	}
}