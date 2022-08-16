package com.qa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.entity.User;
import com.qa.service.UserService;

@RestController
@CrossOrigin

public class UserController {

	public UserController(UserService userService) {
		this.service = userService;
	}

	@Autowired
	private UserService service;

	// GET
	@GetMapping("/getUser")
	public ResponseEntity<List<User>> getUser() {
		List<User> UserData = this.service.readAllUsers();

		return new ResponseEntity<List<User>>(UserData, HttpStatus.OK);
	}

	// POST
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createUser = this.service.addUser(user);

		return new ResponseEntity<User>(createUser, HttpStatus.CREATED);

	}

	// PUT
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateWorkoutChecklist(@RequestBody User user, @PathVariable String id) {
		User updateUser = service.updateUser(user, id);

		return new ResponseEntity<User>(updateUser, HttpStatus.I_AM_A_TEAPOT);

	}

	// DELETE
	@DeleteMapping("deleteUser/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable String Name) {

		Boolean deletedUser = service.deleteByName(Name);

		return (deletedUser) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

}