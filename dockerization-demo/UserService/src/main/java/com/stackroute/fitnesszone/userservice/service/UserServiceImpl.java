package com.stackroute.fitnesszone.userservice.service;

import com.stackroute.fitnesszone.userservice.entity.User;
import com.stackroute.fitnesszone.userservice.exception.InvalidCredentialsException;
import com.stackroute.fitnesszone.userservice.exception.UserAlreadyExistsException;
import com.stackroute.fitnesszone.userservice.exception.UserNotFoundException;
import com.stackroute.fitnesszone.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {
        if (userRepository.findById(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(user);
    }

    @Override
    public User updateProfile(User user) throws UserNotFoundException {
        if (userRepository.findById(user.getEmail()).isEmpty()) {
            throw new UserNotFoundException();
        }
        return userRepository.save(user);
    }


    @Override
    public User login(User user) throws UserNotFoundException, InvalidCredentialsException {
        if (userRepository.findById(user.getEmail()).isEmpty()) {
            throw new UserNotFoundException();
        }
        User retrievedUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (retrievedUser == null) {
            throw new InvalidCredentialsException();
        }
        return retrievedUser;
    }

    @Override
    public boolean validateUser(String email) {
        return ((userRepository.findByEmailAndRole(email, "Executive")) != null);
    }


    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public User getUserByEmail(String email) throws UserNotFoundException {
        if (userRepository.findById(email).isEmpty()) {
            throw new UserNotFoundException();
        }
        return userRepository.findById(email).get();
    }

}
