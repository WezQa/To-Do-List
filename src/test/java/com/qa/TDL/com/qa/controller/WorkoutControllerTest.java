package com.qa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.entity.WorkoutChecklist;
import com.qa.service.WorkoutService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class WorkoutControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private WorkoutService service;

	@Test
	public void createWorkoutssTest() throws Exception {
		// This is essentially what Im going to be parsing in
		// Doing the same thing Ive done so far with PostMan
		WorkoutChecklist testWorkoutChecklist = new WorkoutChecklist("Bench Press", 50l, 8l, true);
		// Cat expectedCat = new Cat(1L,"Bobby Brown", 12);
		String testWorkoutChecklistAsJSON = this.mapper.writeValueAsString(testWorkoutChecklist);

		// Mimic my behaviour -- the actual a save
		// Service
		Mockito.when(this.service.addWorkoutChecklist(testWorkoutChecklist)).thenReturn(testWorkoutChecklist);

		// Mimic the behaviour of our Postman actitivity
		// User -- On the internet
		mvc.perform(post("/home/WorkoutChecklist").content(testWorkoutChecklistAsJSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(content().json(testWorkoutChecklistAsJSON));

		Mockito.verify(this.service, Mockito.times(1)).addWorkoutChecklist(testWorkoutChecklist);

	}

}