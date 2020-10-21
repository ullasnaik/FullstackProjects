package org.example.springjdbcdemo.service;

import org.example.springjdbcdemo.exception.ServiceException;
import org.example.springjdbcdemo.model.User;

import java.util.List;

public interface UserService {
  void saveUser(User user) throws ServiceException;
  User getUserByUsername(String username) throws ServiceException;
  User getUserByUsernameAndPassword(String username, String password) throws ServiceException;
  List<User> getAllUsers() throws ServiceException;
  void createTable() throws ServiceException;
}
