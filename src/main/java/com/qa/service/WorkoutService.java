package com.qa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.entity.WorkoutChecklist;
import com.qa.repo.WorkoutRepo;

@Service
public class WorkoutService {

	@Autowired
	private WorkoutRepo workoutRepo;

	public WorkoutService(WorkoutRepo workoutRepo) {
		this.workoutRepo = workoutRepo;
	}

	// POST
	public WorkoutChecklist addWorkoutChecklist(WorkoutChecklist workoutChecklist) {
		return workoutRepo.save(workoutChecklist);
	}

	// GET
	public WorkoutChecklist readWorkoutChecklist(Long id) {
		return workoutRepo.findById(id).get();
	}

	public List<WorkoutChecklist> readAllWorkoutChecklists() {
		return this.workoutRepo.findAll();
	}

	// PUT
	public WorkoutChecklist updateWorkoutChecklist(WorkoutChecklist updateWorkoutChecklist, Long id) {
		Optional<WorkoutChecklist> currentWorkoutChecklist = this.workoutRepo.findById(id);

		if (currentWorkoutChecklist.get() instanceof WorkoutChecklist) {
			WorkoutChecklist oldWorkoutChecklist = currentWorkoutChecklist.get();

			oldWorkoutChecklist.setWorkout(updateWorkoutChecklist.getWorkout());
			oldWorkoutChecklist.setKg(updateWorkoutChecklist.getKg());
			oldWorkoutChecklist.setReps(updateWorkoutChecklist.getReps());
			oldWorkoutChecklist.setDone(updateWorkoutChecklist.getDone());

			return workoutRepo.save(oldWorkoutChecklist);
		}
		return null;

	}

	// DELETE
	public boolean deleteByWorkoutChecklistID(Long id) {
		Optional<WorkoutChecklist> currentWorkoutChecklist = this.workoutRepo.findById(id);

		boolean isPresent = (currentWorkoutChecklist.isPresent()) ? true : false;

		if (isPresent) {
			this.workoutRepo.deleteById(id);
			return true;
		} else {
			return false;
		}

	}

}
