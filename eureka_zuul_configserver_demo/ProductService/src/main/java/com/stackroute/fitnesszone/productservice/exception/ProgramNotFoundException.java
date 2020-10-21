package com.stackroute.fitnesszone.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Specified Program Not Found")
public class ProgramNotFoundException extends Exception {

}
