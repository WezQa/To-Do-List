package com.qa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "Workout")

public class WorkoutChecklist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private String Workout;
	private Long Kg;
	private Long Reps;
	private Boolean Done;

}