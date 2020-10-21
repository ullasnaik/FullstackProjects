package org.example.springormdemo.service;

import org.example.springormdemo.exception.ServiceException;
import org.example.springormdemo.model.User;

import java.util.List;


public interface UserService {
  void saveUser(User user) throws ServiceException;
  User getUserByUsername(String username) throws ServiceException;
  User getUserByUsernameAndPassword(String username, String password) throws ServiceException;
  List<User> getAllUsers() throws ServiceException;
}
