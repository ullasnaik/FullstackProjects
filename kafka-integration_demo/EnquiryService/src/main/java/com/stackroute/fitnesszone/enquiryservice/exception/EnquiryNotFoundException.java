package com.stackroute.fitnesszone.enquiryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Enquiry with specified details not found")
public class EnquiryNotFoundException extends Exception {

}
