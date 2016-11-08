package org.launchcode.blogz.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostAndUserTest {

	@Test
	public void testIsValidUsername() {
		String name = "Big-Bad-Wolf";
		String name1 = "hello there";
		String name2 = "name1";
		assertTrue("name should be valid", User.isValidUsername(name));
		assertFalse("name should not be valid", User.isValidUsername(name1));
		assertTrue("name should be valid", User.isValidUsername(name2));
	}
	
	@Test
	public void testIsValidPassword() {
		String name = "Big-Bad-Wolf";
		String password = "password";
		User u = new User(name, password);
		assertTrue("passwords do not match", u.isValidPassword(password));
	}
	
}
