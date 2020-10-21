package com.stackroute.dockerbasic.dockerdemo1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/book")
public class book {
    @GetMapping("/getallbooks")
    public ResponseEntity<?> listBooks(){
        return new ResponseEntity<>("Hello All books", HttpStatus.OK);
    }
}
