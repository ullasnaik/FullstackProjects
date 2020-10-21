package com.stackroute.fitnesszone.userservice.controller;

import com.stackroute.fitnesszone.userservice.entity.User;
import com.stackroute.fitnesszone.userservice.exception.InvalidCredentialsException;
import com.stackroute.fitnesszone.userservice.exception.UserAlreadyExistsException;
import com.stackroute.fitnesszone.userservice.exception.UserNotFoundException;
import com.stackroute.fitnesszone.userservice.security.SecurityTokenGenerator;
import com.stackroute.fitnesszone.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/userservice")
public class UserController {

    private UserService userService;

    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) throws UserNotFoundException {
        return new ResponseEntity<>(userService.updateProfile(user), HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws InvalidCredentialsException, UserNotFoundException {

//        return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
        Map<String, String> map = null;
        User retrievedUser = userService.login(user);

        if(retrievedUser!=null) {
            map = securityTokenGenerator.generateToken(user);
        }

        return new ResponseEntity<>(map,HttpStatus.OK);
    }


    @GetMapping("/{email}")
    public ResponseEntity<?> validateUser(@PathVariable String email) {
        return new ResponseEntity<>(userService.validateUser(email), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<?> listAllUsers() {
        return new ResponseEntity<>(userService.listAllUsers(), HttpStatus.OK);
    }


    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

}
