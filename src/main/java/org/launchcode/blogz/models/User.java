package org.launchcode.blogz.models;

import java.util.ArrayList;
import java.util.List;

public class User extends Entity {
	
	private String username;
	private String passwordHash;
	private static List<User> users = new ArrayList<User>();
	
	public User(String username, String password) {
		super();
		if (isValidUsername(username))
			this.username = username;
		else
			throw new IllegalArgumentException("Invalid username characters");
		this.passwordHash = hashPassword(password);
		users.add(this);
	}
	
	
	public String hashPassword(String password) {
		return password;
	}
	
	public static boolean isValidUsername(String username) {
		return username.matches("[a-zA-Z][a-zA-Z0-9_-]{4,11}");
	}
	
	public boolean isValidPassword(String password) {
		return (hashPassword(password) == passwordHash);
	}
	
	public static void generateList() {
		for (User user : users)
			System.out.println("Username: " + user.username);
	}
	
}