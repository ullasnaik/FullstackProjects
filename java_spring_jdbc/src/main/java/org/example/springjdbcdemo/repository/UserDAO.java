package org.example.springjdbcdemo.repository;

import org.example.springjdbcdemo.exception.DAOException;
import org.example.springjdbcdemo.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
  void saveUser(User user) throws DAOException;
  User getUserByUsername(String username) throws DAOException;
  User getUserByUsernameAndPassword(String username, String password) throws DAOException;
  List<User> getAllUsers() throws DAOException;
  void createTable() throws DAOException;
}
