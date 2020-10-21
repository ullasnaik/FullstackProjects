package com.stackroute.userservice.service;

import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User registerUser(User user) throws UserAlreadyExistsException;

    User login(String email, String password) throws UserNotFoundException;

    User updateUser(User user) throws UserNotFoundException;
}
