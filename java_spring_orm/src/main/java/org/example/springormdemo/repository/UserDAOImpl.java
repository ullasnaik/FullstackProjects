package org.example.springormdemo.repository;

import org.example.springormdemo.exception.DAOException;
import org.example.springormdemo.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{
  @Autowired
  private SessionFactory sessionFactory;


  @Override
  @Transactional
  public void saveUser(User user) throws DAOException {
      Session session = null;
      session = sessionFactory.getCurrentSession();
      session.save(user);
  }

  @Override
  @Transactional
  public User getUserByUsername(String username) throws DAOException {
    Session session = sessionFactory.getCurrentSession();
    String hql = "from User where username = :username";
    Query query = session.createQuery(hql);
    query.setParameter("username", username);
    return (User) query.getSingleResult();
  }

  @Override
  @Transactional
  public User getUserByUsernameAndPassword(String username, String password) throws DAOException {
    Session session = sessionFactory.getCurrentSession();
    String hql = "from User where username = :username and password = :password";
    Query query = session.createQuery(hql);
    query.setParameter("username", username);
    query.setParameter("password", password);
    try {
      return (User) query.getSingleResult();
    } catch (NoResultException e) {
      throw new DAOException("User not present");
    }
  }

  @Override
  @Transactional
  public List getAllUsers() throws DAOException {
    Session session = sessionFactory.getCurrentSession();
    String hql = "from User";
    Query query = session.createQuery(hql);
    return query.getResultList();
  }
}
