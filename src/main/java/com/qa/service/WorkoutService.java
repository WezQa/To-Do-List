package com.qa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.entity.WorkoutChecklist;
import com.qa.repo.WorkoutRepository;

@Service
public class WorkoutService {

	@Autowired
	private WorkoutRepository workoutRepository;

	public WorkoutService(WorkoutRepository workoutRepository) {
		this.workoutRepository = workoutRepository;
	}

	// POST
	public WorkoutChecklist addWorkoutChecklist(WorkoutChecklist workoutChecklist) {
		return workoutRepository.save(workoutChecklist);
	}

	// GET
	public WorkoutChecklist readWorkoutChecklist(Long id) {
		return workoutRepository.findById(id).get();
	}

	public List<WorkoutChecklist> readAllWorkoutChecklists() {
		return this.workoutRepository.findAll();
	}

	// PUT
	public WorkoutChecklist updateWorkoutChecklist(WorkoutChecklist updateWorkoutChecklist, Long id) {
		Optional<WorkoutChecklist> currentWorkoutChecklist = this.workoutRepository.findById(id);

		if (currentWorkoutChecklist.get() instanceof WorkoutChecklist) {
			WorkoutChecklist oldWorkoutChecklist = currentWorkoutChecklist.get();

			oldWorkoutChecklist.setWorkout(updateWorkoutChecklist.getWorkout());
			oldWorkoutChecklist.setKg(updateWorkoutChecklist.getKg());
			oldWorkoutChecklist.setReps(updateWorkoutChecklist.getReps());
			oldWorkoutChecklist.setDone(updateWorkoutChecklist.getDone());

			return workoutRepository.save(oldWorkoutChecklist);
		}
		return null;

	}

	// DELETE
	public boolean deleteByWorkoutChecklistID(Long id) {
		Optional<WorkoutChecklist> currentWorkoutChecklist = this.workoutRepository.findById(id);

		boolean isPresent = (currentWorkoutChecklist.isPresent()) ? true : false;

		if (isPresent) {
			this.workoutRepository.deleteById(id);
			return true;
		} else {
			return false;
		}

	}

}
