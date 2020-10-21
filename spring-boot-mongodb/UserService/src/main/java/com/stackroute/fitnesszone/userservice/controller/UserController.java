package com.stackroute.fitnesszone.userservice.controller;

import com.stackroute.fitnesszone.userservice.entity.User;
import com.stackroute.fitnesszone.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/userservice")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        return new ResponseEntity<>(userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword()), HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<?> listAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }


    @GetMapping(value = "/getByEmail/{email:.+}")
    public ResponseEntity<?> getUserByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(userRepository.findById(email), HttpStatus.OK);
    }

}
