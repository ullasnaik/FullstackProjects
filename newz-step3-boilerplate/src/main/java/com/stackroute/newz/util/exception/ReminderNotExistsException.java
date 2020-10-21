package com.stackroute.newz.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Matching Reminder not found")
public class ReminderNotExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
