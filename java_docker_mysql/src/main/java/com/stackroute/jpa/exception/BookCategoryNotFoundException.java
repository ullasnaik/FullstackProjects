package com.stackroute.jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Specified Product Not Found")
public class BookCategoryNotFoundException extends Exception {
}
