package com.qa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.entity.WorkoutChecklist;
import com.qa.service.WorkoutService;

@RestController
@RequestMapping("/home")
public class Controller {

	@Autowired
	WorkoutService service;

	public Controller(WorkoutService workoutService) {
		this.service = workoutService;
	}

	@GetMapping()
	public String showHOne() {
		return "<h1> Hello World </h1> " + "<br/>" + "<p> Hello Everyone </p>";
	}

	// GET
	@GetMapping("/getWorkoutChecklist")
	public ResponseEntity<List<WorkoutChecklist>> getWorkoutChecklist() {
		List<WorkoutChecklist> workoutChecklistData = this.service.readAllWorkoutChecklists();

		return new ResponseEntity<List<WorkoutChecklist>>(workoutChecklistData, HttpStatus.OK);
	}

	// POST
	@PostMapping("/createWorkoutChecklist")
	public ResponseEntity<WorkoutChecklist> createWorkoutChecklist(@RequestBody WorkoutChecklist workoutChecklist) {
		WorkoutChecklist createWorkoutChecklist = this.service.addWorkoutChecklist(workoutChecklist);

		return new ResponseEntity<WorkoutChecklist>(createWorkoutChecklist, HttpStatus.CREATED);

	}

	// PUT
	@PutMapping("/updateWorkoutChecklist/{id}")
	public ResponseEntity<WorkoutChecklist> updateWorkoutChecklist(@RequestBody WorkoutChecklist workoutChecklist,
			@PathVariable Long id) {
		WorkoutChecklist updateWorkoutChecklist = service.updateWorkoutChecklist(workoutChecklist, id);

		return new ResponseEntity<WorkoutChecklist>(updateWorkoutChecklist, HttpStatus.I_AM_A_TEAPOT);

	}

	// DELETE
	@DeleteMapping("deleteWorkoutChecklist/{id}")
	public ResponseEntity<Boolean> deleteWorkoutChecklist(@PathVariable Long id) {

		Boolean deletedWorkoutChecklist = service.deleteByWorkoutChecklistID(id);

		return (deletedWorkoutChecklist) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

}
