package com.qa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.entity.WorkoutChecklist;

@Repository
public interface WorkoutRepo extends JpaRepository<WorkoutChecklist, Long> {

	WorkoutChecklist findByWorkout(String Workout);

	List<WorkoutChecklist> findAllByid(Long id);

}
