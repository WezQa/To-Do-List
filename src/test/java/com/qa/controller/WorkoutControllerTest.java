package com.qa.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.entity.WorkoutChecklist;
import com.qa.service.WorkoutService;

@RunWith(MockitoJUnitRunner.class)
public class WorkoutControllerTest {

	@Mock
	private WorkoutService service;

	@InjectMocks
	private WorkoutController controller;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testGetAllWorkoutChecklist() {
		List<WorkoutChecklist> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(new WorkoutChecklist("Bench Press", 50l, 8l, true));
		MOCK_LIST.add(new WorkoutChecklist("Squats", 50l, 8l, true));
		when(service.readAllWorkoutChecklists()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, controller.getWorkoutChecklist());

	}

	@Test
	public void testCreateWorkoutChecklist() {
		WorkoutChecklist MOCK_VALUE = new WorkoutChecklist("Bench Press", 50l, 8l, true);
		when(service.addWorkoutChecklist(MOCK_VALUE)).thenReturn(MOCK_VALUE);
		ResponseEntity<WorkoutChecklist> result = controller.updateWorkoutChecklist(MOCK_VALUE, null);
		assertEquals(result.getStatusCode(), HttpStatus.CREATED);
		assertEquals(result.getBody(), MOCK_VALUE);

	}

	@Test
	public void testupdateWorkoutChecklist() {
		WorkoutChecklist MOCK_VALUE = new WorkoutChecklist("Bench Press", 50l, 8l, true);
		when(service.updateWorkoutChecklist(MOCK_VALUE, 1L)).thenReturn(MOCK_VALUE);
		ResponseEntity<WorkoutChecklist> result = controller.updateWorkoutChecklist(MOCK_VALUE, 1L);
		assertEquals(result.getStatusCode(), HttpStatus.I_AM_A_TEAPOT);
		assertEquals(result.getBody(), MOCK_VALUE);

	}

	@Test
	public void testDeleteWorkoutChecklist() {
		Boolean MOCK_DELETE_VALUE = true;
		when(service.deleteByWorkoutChecklistID(1L)).thenReturn(MOCK_DELETE_VALUE);
		ResponseEntity<Boolean> result = controller.deleteWorkoutChecklist(1L);
		assertEquals(result.getStatusCode(), HttpStatus.NO_CONTENT);

	}

}