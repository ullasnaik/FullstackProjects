package com.stackroute.newz.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.annotation.Rollback;

import com.stackroute.newz.model.Reminder;
import com.stackroute.newz.repository.ReminderRepository;
import com.stackroute.newz.service.ReminderServiceImpl;
import com.stackroute.newz.util.exception.ReminderNotExistsException;

class ReminderServiceTest {

	@Mock
	private ReminderRepository reminderRepository;
	@InjectMocks
	private ReminderServiceImpl reminderService;

	private Reminder reminder;

	private List<Reminder> reminderList;

	@BeforeEach
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
		reminderList = new ArrayList<Reminder>();
		reminder = new Reminder(1, LocalDateTime.now(), null);
		Reminder reminder1 = new Reminder(2, LocalDateTime.now(), null);
		Reminder reminder2 = new Reminder(3, LocalDateTime.now(), null);
		reminderList.add(reminder1);
		reminderList.add(reminder2);

	}

	@AfterEach
	public void tearDown() throws Exception {
		reminder = null;
		reminderList = null;
	}

	@Test
	@Rollback(true)
	public void testAddReminderSuccess() {

		when(reminderRepository.save(any())).thenReturn(reminder);

		assertEquals(reminder, reminderService.addReminder(reminder));

		verify(reminderRepository, times(1)).save(any());

	}

	@Test
	@Rollback(true)
	public void testGetReminderSuccess() throws ReminderNotExistsException {

		when(reminderRepository.findById(any())).thenReturn(Optional.of(reminder));

		assertEquals(reminder, reminderService.getReminder(reminder.getReminderId()));

		verify(reminderRepository, times(1)).findById(any());

	}

	@Test
	@Rollback(true)
	public void testGetReminderFailure() {

		when(reminderRepository.findById(any())).thenReturn(Optional.empty());

		assertThrows(ReminderNotExistsException.class, () -> reminderService.getReminder(reminder.getReminderId()));

		verify(reminderRepository, times(1)).findById(any());

	}

	@Test
	@Rollback(true)
	public void testGetAllReminderSuccess() {

		when(reminderRepository.findAll()).thenReturn(reminderList);

		assertEquals(reminderList, reminderService.getAllReminders());

		verify(reminderRepository, times(1)).findAll();

	}

	@Test
	@Rollback(true)
	public void testUpdateReminderSuccess() throws ReminderNotExistsException {

		when(reminderRepository.getOne(any())).thenReturn(reminder);
		when(reminderRepository.saveAndFlush(any())).thenReturn(reminder);

		assertEquals(reminder, reminderService.updateReminder(reminder));

		verify(reminderRepository, times(1)).getOne(any());
		verify(reminderRepository, times(1)).saveAndFlush(any());

	}

	@Test
	@Rollback(true)
	public void testUpdateReminderFailure() {

		when(reminderRepository.getOne(any())).thenReturn(null);

		assertThrows(ReminderNotExistsException.class, () -> reminderService.updateReminder(reminder));

		verify(reminderRepository, times(1)).getOne(any());
		verify(reminderRepository, times(0)).saveAndFlush(any());

	}

	@Test
	@Rollback(true)
	public void testDeleteReminderSuccess() throws ReminderNotExistsException {

		when(reminderRepository.getOne(any())).thenReturn(reminder);
		reminderService.deleteReminder(reminder.getReminderId());

		verify(reminderRepository, times(1)).getOne(any());
		verify(reminderRepository, times(1)).deleteById(any());

	}

	@Test
	@Rollback(true)
	public void testDeleteReminderFailure() {

		when(reminderRepository.getOne(any())).thenReturn(null);

		assertThrows(ReminderNotExistsException.class, () -> reminderService.deleteReminder(reminder.getReminderId()));

		verify(reminderRepository, times(1)).getOne(any());
		verify(reminderRepository, times(0)).deleteById(any());

	}

}
