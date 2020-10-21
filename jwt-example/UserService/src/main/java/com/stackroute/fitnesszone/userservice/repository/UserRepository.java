package com.stackroute.fitnesszone.userservice.repository;

import com.stackroute.fitnesszone.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByEmailAndPassword(String email,String password);

    List<User> findByRole(String role);

    User findByEmailAndRole(String email, String role);

    User findByEmailAndPasswordAndRole(String email, String password, String role);

}
