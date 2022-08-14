package com.qa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.entity.User;
import com.qa.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	// POST
	public User addUser(User user) {
		return userRepo.save(user);
	}

	// GET
	public User readUser(String Name) {
		return userRepo.findByName(Name).get();
	}

	public List<User> readAllUsers() {
		return this.userRepo.findAll();
	}

	// PUT
	public User updateUser(User updateUser, String Name) {
		Optional<User> currentUser = this.userRepo.findByName(Name);

		if (currentUser.get() instanceof User) {
			User oldUser = currentUser.get();

			oldUser.setName(updateUser.getName());

			return userRepo.save(oldUser);
		}
		return null;

	}

	// DELETE
	public boolean deleteByName(String Name) {
		Optional<User> currentUser = this.userRepo.findByName(Name);

		boolean isPresent = (currentUser.isPresent()) ? true : false;

		if (isPresent) {
			this.userRepo.deleteAll();
			return true;
		} else {
			return false;
		}

	}

}
