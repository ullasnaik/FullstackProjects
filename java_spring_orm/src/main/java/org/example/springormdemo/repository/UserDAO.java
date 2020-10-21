package org.example.springormdemo.repository;

import org.example.springormdemo.exception.DAOException;
import org.example.springormdemo.model.User;

import java.util.List;

public interface UserDAO {
  void saveUser(User user) throws DAOException;
  User getUserByUsername(String username) throws DAOException;
  User getUserByUsernameAndPassword(String username, String password) throws DAOException;
  List<User> getAllUsers() throws DAOException;
}
