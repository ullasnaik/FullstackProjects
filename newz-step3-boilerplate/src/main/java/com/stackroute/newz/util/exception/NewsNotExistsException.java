package com.stackroute.newz.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "News with specified details not found")
public class NewsNotExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
