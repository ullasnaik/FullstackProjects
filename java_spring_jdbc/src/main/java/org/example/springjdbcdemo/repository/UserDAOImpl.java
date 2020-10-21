package org.example.springjdbcdemo.repository;

import org.example.springjdbcdemo.exception.DAOException;
import org.example.springjdbcdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
  @Autowired
  private DataSource dataSource;

  @Override
  public void saveUser(User user) throws DAOException {
    String query = "insert into User (username, password) values (?, ?)";
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    try {
      conn = dataSource.getConnection();
      preparedStatement = conn.prepareStatement(query);
      preparedStatement.setString(1, user.getUsername());
      preparedStatement.setString(2, user.getPassword());
      int result = preparedStatement.executeUpdate();
      if (result != 0) {
        System.out.printf("user with username: %s, succesfully saved", user.getUsername());
      } else {
        System.out.printf("user with username: %s, could not be saved", user.getUsername());
      }
    } catch (SQLException e) {
      throw new DAOException("DAO exception");
    } finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
        if(conn != null) {
          conn.close();
        }
      } catch (SQLException exception) {
        exception.printStackTrace();
      }
    }
  }

  @Override
  public User getUserByUsername(String username) throws DAOException {
    String query = "select * from User where username = ?";
    User user = null;
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    try {
      conn = dataSource.getConnection();
      preparedStatement = conn.prepareStatement(query);
      preparedStatement.setString(1, username);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        user = new User(username);
      }
      resultSet.close();
    } catch (SQLException e) {
      throw new DAOException("DAO exception");
    } finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
        if(conn != null) {
          conn.close();
        }
      } catch (SQLException exception) {
        exception.printStackTrace();
      }
    }
    return user;
  }

  @Override
  public User getUserByUsernameAndPassword(String username, String password) throws DAOException {
    String query = "select * from User where username = ? and password = ?";
    User user = null;
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    try {
      conn = dataSource.getConnection();
      preparedStatement = conn.prepareStatement(query);
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, password);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        user = new User(username);
      }
      resultSet.close();
    } catch (SQLException e) {
      System.out.println("SQLException caught");
      e.printStackTrace();
      throw new DAOException("DAO exception");
    } finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
        if(conn != null) {
          conn.close();
        }
      } catch (SQLException exception) {
        exception.printStackTrace();
      }
    }
    return user;
  }

  @Override
  public List<User> getAllUsers() throws DAOException {
    String query = "select * from User";
    List <User> users = new ArrayList<>();
    Connection conn = null;
    User user = null;
    PreparedStatement preparedStatement = null;
    try {
      conn = dataSource.getConnection();
      preparedStatement = conn.prepareStatement(query);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        user = new User(resultSet.getString("username"));
        users.add(user);
      }
      resultSet.close();
    } catch (SQLException e) {
      throw new DAOException("DAO exception");
    } finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
        if(conn != null) {
          conn.close();
        }
      } catch (SQLException exception) {
        exception.printStackTrace();
      }
    }
    return users;
  }

  @Override
  public void createTable() throws DAOException {
    String query = "create table User (username varchar(30), password varchar(100))";
    Connection conn = null;
    User user = null;
    PreparedStatement preparedStatement = null;
    try {
      conn = dataSource.getConnection();
      preparedStatement = conn.prepareStatement(query);
      int result = preparedStatement.executeUpdate();
      if (result == 0) {
        throw new DAOException("DAO exception");
      }
    } catch (SQLException e) {
      throw new DAOException("DAO exception");
    } finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
        if(conn != null) {
          conn.close();
        }
      } catch (SQLException exception) {
        exception.printStackTrace();
      }
    }
  }
}
