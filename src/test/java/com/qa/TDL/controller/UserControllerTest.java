package com.qa.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.entity.User;
import com.qa.service.UserService;

@RunWith(MockitoJUnitRunner.class)
class UserControllerTest {

	@Mock
	private UserService service;

	@InjectMocks
	private UserController controller;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testGetAllUsers() {
		List<User> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(new User(0, "Steeve"));
		MOCK_LIST.add(new User(1, "Steeve"));
		when(service.readAllUsers()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, controller.getUser());

	}

	@Test
	public void testCreateUser() {
		User MOCK_VALUE = new User(0, "Steeve");
		when(service.addUser(MOCK_VALUE)).thenReturn(MOCK_VALUE);
		ResponseEntity<User> result = controller.updateWorkoutChecklist(MOCK_VALUE, null);
		assertEquals(result.getStatusCode(), HttpStatus.CREATED);
		assertEquals(result.getBody(), MOCK_VALUE);

	}

	@Test
	public void testupdateUser() {
		User MOCK_VALUE = new User(0, "Steeve");
		when(service.updateUser(MOCK_VALUE, "Bob")).thenReturn(MOCK_VALUE);
		ResponseEntity<User> result = controller.updateUser(MOCK_VALUE, "Bob");
		assertEquals(result.getStatusCode(), HttpStatus.I_AM_A_TEAPOT);
		assertEquals(result.getBody(), MOCK_VALUE);

	}

	@Test
	public void testDeleteUser() {
		Boolean MOCK_DELETE_VALUE = true;
		when(service.deleteByName("Bob")).thenReturn(MOCK_DELETE_VALUE);
		ResponseEntity<Boolean> result = controller.deleteUser("Bob");
		assertEquals(result.getStatusCode(), HttpStatus.NO_CONTENT);

	}

}