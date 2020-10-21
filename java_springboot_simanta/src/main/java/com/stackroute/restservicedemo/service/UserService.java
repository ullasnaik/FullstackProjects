package com.stackroute.restservicedemo.service;

import com.stackroute.restservicedemo.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUsers();
    List<User> getAllUsersByAge();
    List<User> getAllUsersByHisLastNameAndAge();

}
