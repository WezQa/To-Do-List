package com.qa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data

public class WorkoutChecklist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private String workout;
	private Long kg;
	private Long reps;
	private Boolean done;

}
