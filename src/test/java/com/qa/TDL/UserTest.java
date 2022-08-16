package com.qa.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

class UserTest {

	static User testUser;

	@BeforeAll
	public static void buildUser() {
		System.out.println("Builidng User");
		testUser = new User(0, "Steve");
	}

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(User.class).verify();
	}

	@Test
	public void constructors_User_User() {
		// Create Cat
		User Userone = new User();

		assertTrue(Userone instanceof User == true);

		User Usertwo = new User(0, "Winston");

		assertTrue(Usertwo instanceof User == true);
		assertEquals("Winston", Usertwo.getName());

//			Cat catOne = new Cat();
		//
//			assertTrue(catOne instanceof Cat == true);

	}

	// Unit testing we are testing the functions in seldom

	// Test some getters and setters and test your constructor

	// Try and make your tests first -- TDD -- Code work for your tests

}
