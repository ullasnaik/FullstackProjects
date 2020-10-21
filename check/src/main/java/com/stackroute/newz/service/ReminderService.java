package com.stackroute.newz.service;

import java.util.List;

import com.stackroute.newz.model.Reminder;
import com.stackroute.newz.util.exception.ReminderNotExistsException;

public interface ReminderService {

	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */
	public Reminder addReminder(Reminder reminder);

	public Reminder updateReminder(Reminder reminder) throws ReminderNotExistsException;

	public void deleteReminder(int reminderId) throws ReminderNotExistsException;

	public Reminder getReminder(int reminderId) throws ReminderNotExistsException;

	public List<Reminder> getAllReminders();

}
