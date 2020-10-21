package com.stackroute.fitnesszone.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Specified Program Already Exists")
public class ProgramAlreadyExistsException extends Exception {

}
