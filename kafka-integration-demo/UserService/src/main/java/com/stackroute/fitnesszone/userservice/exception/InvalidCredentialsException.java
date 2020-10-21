package com.stackroute.fitnesszone.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Invalid Credentials!!")
public class InvalidCredentialsException extends Exception {
}
