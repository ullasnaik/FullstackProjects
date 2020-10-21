package com.stackroute.newz.test.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.newz.controller.ReminderController;
import com.stackroute.newz.model.Reminder;
import com.stackroute.newz.service.ReminderService;
import com.stackroute.newz.util.exception.NewsNotExistsException;
import com.stackroute.newz.util.exception.ReminderNotExistsException;

@SpringBootTest
class ReminderControllerTest {

	private MockMvc mockMvc;
	private Reminder reminder;
	private List<Reminder> reminderList;

	@Mock
	ReminderService reminderService;
	@InjectMocks
	ReminderController reminderController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		reminderList = new ArrayList<Reminder>();
		mockMvc = MockMvcBuilders.standaloneSetup(reminderController).build();
		reminder = new Reminder(1, LocalDateTime.now(), null);
		Reminder reminder1 = new Reminder(2, LocalDateTime.now(), null);
		Reminder reminder2 = new Reminder(3, LocalDateTime.now(), null);
		reminderList.add(reminder1);
		reminderList.add(reminder2);
	}

	@Test
	public void getAllRemindersSuccess() throws Exception {

		when(reminderService.getAllReminders()).thenReturn(reminderList);
		mockMvc.perform(get("/api/v1/reminder")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void getByReminderIdSuccess() throws Exception {

		when(reminderService.getReminder(1)).thenReturn(reminder);
		mockMvc.perform(get("/api/v1/reminder/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void getByReminderIdFailure() throws Exception {

		when(reminderService.getReminder(2)).thenThrow(ReminderNotExistsException.class);
		mockMvc.perform(get("/api/v1/reminder/2")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void addReminderSuccess() throws Exception {

		when(reminderService.addReminder(any())).thenReturn(reminder);
		mockMvc.perform(post("/api/v1/reminder").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(reminder)))
				.andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());

	}

	@Test
	public void updateReminderSuccess() throws Exception {

		when(reminderService.updateReminder(any())).thenReturn(reminder);
		mockMvc.perform(put("/api/v1/reminder/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(reminder)))
				.andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());

	}

	@SuppressWarnings("unchecked")
	@Test
	public void updateReminderFailure() throws Exception {

		when(reminderService.updateReminder(any())).thenThrow(ReminderNotExistsException.class);
		mockMvc.perform(put("/api/v1/news/2")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(reminder)))
				.andExpect(status().isNotFound())
				.andDo(MockMvcResultHandlers.print());

	}

	@Test
	public void deleteReminderSuccess() throws Exception {
		doNothing().when(reminderService).deleteReminder(anyInt());
		mockMvc.perform(delete("/api/v1/reminder/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());

	}

	@Test
	public void deleteReminderFailure() throws Exception {
		doThrow(NewsNotExistsException.class).doNothing().when(reminderService).deleteReminder(anyInt());
		mockMvc.perform(delete("/api/v1/reminder/2").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
