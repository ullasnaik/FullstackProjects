package org.example.springormdemo.service;

import org.example.springormdemo.exception.DAOException;
import org.example.springormdemo.exception.ServiceException;
import org.example.springormdemo.model.User;
import org.example.springormdemo.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserDAO userDAO;

  @Override
  public void saveUser(User user) throws ServiceException {
    try {
      this.userDAO.saveUser(user);
    } catch (DAOException e) {
      throw new ServiceException("user not saved::service exception");
    }
  }

  @Override
  public User getUserByUsername(String username) throws ServiceException {
    try {
      return this.userDAO.getUserByUsername(username);
    } catch (DAOException e) {
      throw new ServiceException("user not found::service exception :: unauthenticated");
    }
  }

  @Override
  public User getUserByUsernameAndPassword(String username, String password) throws ServiceException {
    try {
      return this.userDAO.getUserByUsernameAndPassword(username, password);
    } catch (DAOException e) {
      throw new ServiceException("user not found::service exception :: unauthenticated");
    }
  }

  @Override
  public List<User> getAllUsers() throws ServiceException {
    try {
      return this.userDAO.getAllUsers();
    } catch (DAOException e) {
      throw new ServiceException("users not found::service exception");
    }
  }
}
