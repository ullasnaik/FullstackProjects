package com.stackroute.restservicedemo.service;

import com.stackroute.restservicedemo.model.User;
import com.stackroute.restservicedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    //ToDo
 @Override
 public List<User> getAllUsersByAge() {
      return null;
 }
    //ToDo
    @Override
    public List<User> getAllUsersByHisLastNameAndAge() {
        return null;
    }


}
