package com.qa.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

class WorkoutChecklistTest {

	// Equals Verifier -- Because we cant be bothered to test our boiler plate code
	// Hash and equals -- If you have an @Id it will fail

	static WorkoutChecklist testWorkoutChecklist;

	@BeforeAll
	public static void buildWorkoutChecklist() {
		System.out.println("WorkoutChecklist");
		testWorkoutChecklist = new WorkoutChecklist("Bench Press", 50l, 8l, true);
	}

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(WorkoutChecklist.class).verify();
	}

	@Test
	public void constructors_WorkoutChecklist_WorkoutChecklist() {
		// Create Cat
		WorkoutChecklist WorkoutChecklistone = new WorkoutChecklist();

		assertTrue(WorkoutChecklistone instanceof WorkoutChecklist == true);

		WorkoutChecklist WorkoutChecklisttwo = new WorkoutChecklist("Bench Press", 50l, 8l, true);

		assertTrue(WorkoutChecklisttwo instanceof WorkoutChecklist == true);
		assertEquals("Bench Press", WorkoutChecklisttwo.getWorkout());
		assertEquals(50l, WorkoutChecklisttwo.getKg());
		assertEquals(8l, WorkoutChecklisttwo.getReps());
		assertEquals(true, WorkoutChecklisttwo.getDone());

//			Cat catOne = new Cat();
		//
//			assertTrue(catOne instanceof Cat == true);

	}

	// Unit testing we are testing the functions in seldom

	// Test some getters and setters and test your constructor

	// Try and make your tests first -- TDD -- Code work for your tests

}
