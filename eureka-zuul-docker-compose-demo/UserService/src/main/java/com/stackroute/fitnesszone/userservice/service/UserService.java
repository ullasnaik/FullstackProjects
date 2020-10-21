package com.stackroute.fitnesszone.userservice.service;

import com.stackroute.fitnesszone.userservice.entity.User;
import com.stackroute.fitnesszone.userservice.exception.InvalidCredentialsException;
import com.stackroute.fitnesszone.userservice.exception.UserAlreadyExistsException;
import com.stackroute.fitnesszone.userservice.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    User registerUser(User user) throws UserAlreadyExistsException;

    User updateProfile(User user) throws UserNotFoundException;

    User login(User user) throws UserNotFoundException, InvalidCredentialsException;

    boolean validateUser(String email);

    List<User> listAllUsers();

    User getUserByEmail(String email) throws UserNotFoundException;


}
