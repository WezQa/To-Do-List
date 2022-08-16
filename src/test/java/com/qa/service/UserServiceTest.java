package com.qa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.entity.User;
import com.qa.repo.UserRepo;

@SpringBootTest
class UserServiceTest {

	// Autowired -- We dont have normal control
	// Spring is in control

	@Autowired
	private UserService service;

	@MockBean
	private UserRepo repo;

	// Save a cat into the repo ---

	@Test
	public void createUser_ValidUser_SaveUser() {

		// When we save the cat -- We dont enter an id

		User saveUser = new User(0, "Bobby");
		User repoUser = new User(0, "Bobby");

		// Mockito is a mocking tool -- Dependency Injection tool
		// Script some action

		// Automation testing --
		Mockito.when(this.service.addUser(saveUser)).thenReturn(repoUser);

		assertEquals(repoUser, this.repo.save(saveUser));

		// Only verify your mocks
		Mockito.verify(this.repo, Mockito.times(1)).save(saveUser);

	}

	@Test
	public void updateCat_ValidId_UpdateCat() {

		// Put a cat into the repo and the print it
		Long testId = 1L;
		Optional<User> mockOutputValid = Optional.ofNullable(new User(0, "Bobby"));
		User expectedOutput = new User(0, "Bobby");

		Mockito.when(this.repo.findAllById(testId)).thenReturn(mockOutputValid);
		Mockito.when(mockOutputValid.get().setName(updateUser.getName())).thenReturn(mockOutputValid.get().getName());
		Mockito.when(this.repo.save(expectedOutput)).thenReturn(expectedOutput);

		assertEquals(expectedOutput, this.service.updateUser(expectedOutput, "Steve"));

		// Mokito.verifys
		Mockito.verify(this.repo, Mockito.times(1)).save(expectedOutput);
		Mockito.verify(this.repo, Mockito.times(1)).findById(null);

	}

}
