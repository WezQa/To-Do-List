package com.qa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.entity.WorkoutChecklist;
import com.qa.repo.WorkoutRepo;

class WorkoutServiceTest {

	@SpringBootTest
	public class WorkoutServiceTestUnitTest {

		// Autowired -- We dont have normal control
		// Spring is in control

		@Autowired
		private WorkoutService service;

		@MockBean
		private WorkoutRepo repo;

		// Save a WorkoutChecklist into the repo ---

		@Test
		public void createWorkoutChecklist_ValidWorkoutChecklist_SaveWorkoutChecklist() {

			// When we save the WorkoutChecklist -- We dont enter an id

			WorkoutChecklist saveWorkoutChecklist = new WorkoutChecklist("Bench Press", 50l, 8l, true);
			WorkoutChecklist repoWorkoutChecklist = new WorkoutChecklist("Bench Press", 50l, 8l, true);

			// Mockito is a mocking tool -- Dependency Injection tool
			// Script some action

			// Automation testing --
			Mockito.when(this.service.addWorkoutChecklist(saveWorkoutChecklist)).thenReturn(repoWorkoutChecklist);

			assertEquals(repoWorkoutChecklist, this.repo.save(saveWorkoutChecklist));

			// Only verify your mocks
			Mockito.verify(this.repo, Mockito.times(1)).save(saveWorkoutChecklist);

		}

		@Test
		public void updateWorkoutChecklist_ValidId_UpdateWorkoutChecklist() {

			// Put a WorkoutChecklist into the repo and the print it
			Long testId = 1L;
			Optional<WorkoutChecklist> mockOutputValid = Optional
					.ofNullable(new WorkoutChecklist("Bench Press", 50l, 8l, true));
			WorkoutChecklist expectedOutput = new WorkoutChecklist("Bench Press", 50l, 8l, true);

			Mockito.when(this.repo.findById(testId)).thenReturn(mockOutputValid);
//			Mockito.when(mockOutputValid.get().setAge(updateCat.getAge())).thenReturn(mockOutputValid.get().getAge());
//			Mockito.when(mockOutputValid.get().setName(updateCat.getName())).thenReturn(mockOutputValid.get().getName());
			Mockito.when(this.repo.save(expectedOutput)).thenReturn(expectedOutput);

			// Change the variable -- new cat changes the variables
			// Mockito

			assertEquals(expectedOutput, this.service.updateWorkoutChecklist(expectedOutput, 1L));

			// Mokito.verifys
			Mockito.verify(this.repo, Mockito.times(1)).save(expectedOutput);
			Mockito.verify(this.repo, Mockito.times(1)).findById(testId);

			// Acually update using mockito

		}
	}
}

// Do the same to the rest of the methods ==> ReadAll, Update(one or many),
// Delete
