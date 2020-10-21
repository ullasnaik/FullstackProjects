package com.stackroute.fitnesszone.ticketservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Ticket with specified details not found")
public class TicketNotFoundException extends Exception {

}
