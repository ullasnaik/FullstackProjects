package com.stackroute.newz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.newz.model.Reminder;
import com.stackroute.newz.repository.ReminderRepository;
import com.stackroute.newz.service.ReminderService;
import com.stackroute.newz.util.exception.ReminderNotExistsException;

/*
 * This class is implementing the ReminderService interface. This class has to be annotated with 
 * @Service annotation.
 * @Service - is an annotation that annotates classes at the service layer, thus 
 * clarifying it's role.
 * 
 * */
@Service
public class ReminderServiceImpl implements ReminderService {

	/*
	 * Autowiring should be implemented for the ReminderRepository.
	 */
	@Autowired
	private ReminderRepository reminderRepository;

	/*
	 * Add a new reminder.
	 */
	public Reminder addReminder(Reminder reminder) {

		return reminderRepository.save(reminder);
	}

	/*
	 * Update an existing reminder by it's reminderId. Throw ReminderNotExistsException 
	 * if the reminder with specified reminderId does not exist.
	 */
	public Reminder updateReminder(Reminder reminder) throws ReminderNotExistsException {
		if(reminderRepository.getOne(reminder.getReminderId())==null){
			throw new ReminderNotExistsException();
		}
		return reminderRepository.saveAndFlush(reminder);

	}

	/*
	 * Delete an existing reminder by it's reminderId. Throw ReminderNotExistsException if 
	 * the reminder with specified reminderId does not exist.
	 */
	public void deleteReminder(int reminderId) throws ReminderNotExistsException {
		if(reminderRepository.getOne(reminderId)==null){
			throw new ReminderNotExistsException();
		}
		reminderRepository.deleteById(reminderId);
	
	}

	/*
	 * Retrieve an existing reminder by it's reminderId. Throw ReminderNotExistsException 
	 * if the reminder with specified reminderId does not exist.
	 */
	public Reminder getReminder(int reminderId) throws ReminderNotExistsException {
		Optional<Reminder> optionalReminder = reminderRepository.findById(reminderId);
		if(optionalReminder.isEmpty()){
			throw new ReminderNotExistsException();
		}
		return optionalReminder.get();
	}

	/*
	 * Retrieve all existing reminders
	 */
	public List<Reminder> getAllReminders() {
		return reminderRepository.findAll();
	}

}
