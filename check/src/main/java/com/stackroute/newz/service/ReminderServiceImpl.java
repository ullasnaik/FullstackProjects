package com.stackroute.newz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.newz.model.News;
import com.stackroute.newz.model.Reminder;
import com.stackroute.newz.repository.ReminderRepository;
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
		//Optional<Reminder> remExist = reminderRepository.findById(reminder.getReminderId());
			reminder = reminderRepository.save(reminder);
			return reminder;
	}

	/*
	 * Update an existing reminder by it's reminderId. Throw ReminderNotExistsException 
	 * if the reminder with specified reminderId does not exist.
	 */
	public Reminder updateReminder(Reminder reminder) throws ReminderNotExistsException {
		//Optional<Reminder> reminderExist = reminderRepository.findById(reminder.getReminderId());
		Reminder reminderElm = reminderRepository.getOne(reminder.getReminderId());
		if(reminderElm!=null) {
			Reminder remEntity = reminderRepository.saveAndFlush(reminder);
            return remEntity;
		}else {
			throw new ReminderNotExistsException();
			
		}
	}

	/*
	 * Delete an existing reminder by it's reminderId. Throw ReminderNotExistsException if 
	 * the reminder with specified reminderId does not exist.
	 */
	public void deleteReminder(int reminderId) throws ReminderNotExistsException {

		//Optional<Reminder> reminderExist = reminderRepository.findById(reminderId);
		Reminder reminderElm = reminderRepository.getOne(reminderId);
		if(reminderElm!=null) { 
			reminderRepository.deleteById(reminderId);
		}else {
			throw new ReminderNotExistsException();
			
		}
	}

	/*
	 * Retrieve an existing reminder by it's reminderId. Throw ReminderNotExistsException 
	 * if the reminder with specified reminderId does not exist.
	 */
	public Reminder getReminder(int reminderId) throws ReminderNotExistsException {

		Optional<Reminder> reminderExist = reminderRepository.findById(reminderId);
		if(reminderExist!=null && reminderExist.isPresent()) {
			Reminder reminder = reminderExist.get();
			return reminder;
		}else {
			throw new ReminderNotExistsException();
			
		}
	}

	/*
	 * Retrieve all existing reminders
	 */
	public List<Reminder> getAllReminders() {
		 List<Reminder> reminderList = reminderRepository.findAll();
         
	        if(reminderList!=null && reminderList.size() > 0) {
	            return reminderList;
	        } else {
	            return new ArrayList<Reminder>();
	        }
	}

}
