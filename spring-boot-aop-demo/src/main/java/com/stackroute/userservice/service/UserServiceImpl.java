package com.stackroute.userservice.service;

import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {
        if(userRepository.findById(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) throws UserNotFoundException {
        if(userRepository.findById(email).isEmpty()) {
            throw new UserNotFoundException();
        }
        return userRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {

        if(userRepository.findById(user.getEmail()).isEmpty()) {
            throw new UserNotFoundException();
        }
        return userRepository.save(user);
    }
}
