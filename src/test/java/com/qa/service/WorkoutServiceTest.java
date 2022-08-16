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

@SpringBootTest
public class WorkoutServiceTest {

	// Autowired -- We dont have normal control
	// Spring is in control

	@Autowired
	private WorkoutService service;

	@MockBean
	private WorkoutRepo workoutRepo;

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

		assertEquals(repoWorkoutChecklist, this.workoutRepo.save(saveWorkoutChecklist));

		// Only verify your mocks
		Mockito.verify(this.workoutRepo, Mockito.times(1)).save(saveWorkoutChecklist);
	}

	@Test
	public void updateWorkoutChecklist_ValidId_UpdateWorkoutChecklist() {

		// Put a WorkoutChecklist into the repo and the print it
		Long testId = 1L;
		Optional<WorkoutChecklist> mockOutputValid = Optional
				.ofNullable(new WorkoutChecklist("Bench Press", 50l, 8l, true));
		WorkoutChecklist expectedOutput = new WorkoutChecklist("Bench Press", 50l, 8l, true);

		Mockito.when(this.workoutRepo.findById(testId)).thenReturn(mockOutputValid);
		Mockito.when(mockOutputValid.get().setWorkout(updateWorkoutChecklist.getWorkout()))
				.thenReturn(mockOutputValid.get().getWorkout());
		Mockito.when(mockOutputValid.get().setKg(updateWorkoutChecklist.getKg()))
				.thenReturn(mockOutputValid.get().getKg());
		Mockito.when(mockOutputValid.get().setReps(updateWorkoutChecklist.getReps()))
				.thenReturn(mockOutputValid.get().getReps());
		Mockito.when(mockOutputValid.get().setDone(updateWorkoutChecklist.getDone()))
				.thenReturn(mockOutputValid.get().getDone());

		Mockito.when(this.workoutRepo.save(expectedOutput)).thenReturn(expectedOutput);

		assertEquals(expectedOutput, this.service.updateWorkoutChecklist(expectedOutput, 1L));

		// Mokito.verifys
		Mockito.verify(this.workoutRepo, Mockito.times(1)).save(expectedOutput);
		Mockito.verify(this.workoutRepo, Mockito.times(1)).findById(testId);

	}
}