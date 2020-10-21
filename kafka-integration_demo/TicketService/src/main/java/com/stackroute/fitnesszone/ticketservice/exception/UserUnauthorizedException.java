package com.stackroute.fitnesszone.ticketservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Only an executive could update tickets!!")
public class UserUnauthorizedException extends Exception {
}
