package com.stackroute.newz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.newz.model.Reminder;
import com.stackroute.newz.service.ReminderService;
import com.stackroute.newz.util.exception.ReminderNotExistsException;

/*
 * As in this assignment, we are working with creating RESTful web service, hence annotate
 * the class with @RestController annotation.A class annotated with @Controller annotation
 * has handler methods which returns a view. However, if we use @ResponseBody annotation along
 * with @Controller annotation, it will return the data directly in a serialized 
 * format. Starting from Spring 4 and above, we can use @RestController annotation which 
 * is equivalent to using @Controller and @ResposeBody annotation
 * 
 * Please note that the default path to use this controller should be "/api/v1/reminder"
 */
@RestController
@RequestMapping("/api/v1")
public class ReminderController {

	/*
	 * Autowiring should be implemented for the ReminderService. Please note that we
	 * should not create any object using the new keyword
	 */
	@Autowired
	private ReminderService reminderService ;

	/*
	 * Define a handler method which will get us all reminders.
	 * 
	 * This handler method should return any one of the status messages basis on
	 * different situations: 
	 * 1. 200(OK) - If all reminders found successfully. 
	 * 
	 * This handler method should map to the URL "/api/v1/reminder" using HTTP GET
	 * method.
	 */

	@GetMapping("/reminder")
	public ResponseEntity getAllReminder(){
		return new ResponseEntity<>(reminderService.getAllReminders(), HttpStatus.OK);
	}
	
	

	/*
	 * Define a handler method which will get us the reminder by a reminderId.
	 * 
	 * This handler method should return any one of the status messages basis on
	 * different situations: 
	 * 1. 200(OK) - If the reminder found successfully. 
	 * 2. 404(NOT FOUND) - If the reminder with specified reminderId is not found. 
	 * 
	 * 
	 * This handler method should map to the URL "/api/v1/reminder/{reminderId}" using HTTP GET
	 * method, where "reminderId" should be replaced by a valid reminderId without {}
	 */

	@GetMapping("/reminder/{reminderId}")
	public ResponseEntity getReminder(@PathVariable int reminderId) throws ReminderNotExistsException {
		return new ResponseEntity<>(reminderService.getReminder(reminderId), HttpStatus.OK);
	}
	

	/*
	 * Define a handler method which will create a reminder by reading the Serialized
	 * reminder object from request body and save the reminder in reminder table in database.
	 * Please note that the reminderId has to be unique.
	 * 
	 * This handler method should return any one of the status messages basis on
	 * different situations: 
	 * 1. 201(CREATED - In case of successful creation of the reminder 
	 * 2. 409(CONFLICT) - In case of duplicate reminderId
	 * 
	 * This handler method should map to the URL "/api/v1/reminder" using HTTP POST
	 * method".
	 */

	@PostMapping("/reminder")
	public ResponseEntity addAllReminder(@RequestBody Reminder reminder) {
		return new ResponseEntity<>(reminderService.addReminder(reminder), HttpStatus.CREATED);
	}
	
	

	/*
	 * Define a handler method which will update a specific reminder by reading the
	 * Serialized object from request body and save the updated reminder details in
	 * the reminder table in database and handle ReminderNotExistsException as well. 
	 * 
	 * This handler method should return any one of the status
	 * messages basis on different situations: 
	 * 1. 200(OK) - If the reminder is updated successfully. 
	 * 2. 404(NOT FOUND) - If the reminder with specified reminderId is not found. 
	 * 
	 * This handler method should map to the URL "/api/v1/reminder/{reminderId}" using HTTP PUT
	 * method, where "reminderId" should be replaced by a valid reminderId without {}
	 */

	@PutMapping("/reminder/{reminderId}")
	public ResponseEntity updateAllReminder(@RequestBody Reminder reminder) throws ReminderNotExistsException{
		return new ResponseEntity<>(reminderService.updateReminder(reminder), HttpStatus.OK);
	}
	

	/*
	 * Define a handler method which will delete a reminder from the database.
	 * 
	 * This handler method should return any one of the status messages basis on
	 * different situations: 
	 * 1. 200(OK) - If the reminder deleted successfully. 
	 * 2.404(NOT FOUND) - If the reminder with specified reminderId is not found.
	 * 
	 * This handler method should map to the URL "/api/v1/reminder/{reminderId}" using HTTP
	 * Delete method" where "reminderId" should be replaced by a valid reminderId without {}
	 */

	@DeleteMapping("/reminder/{reminderId}")
	public ResponseEntity deleteReminder(@PathVariable int reminderId) throws ReminderNotExistsException{
		reminderService.deleteReminder(reminderId);
		return ResponseEntity.ok().build();
	}
	

}
