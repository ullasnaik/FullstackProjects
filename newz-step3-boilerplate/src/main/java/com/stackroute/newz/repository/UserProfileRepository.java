package com.stackroute.newz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.newz.model.UserProfile;

/*
* This class is implementing the JpaRepository interface for UserProfile.
* Annotate this class with @Repository annotation
* */
@Repository 
public interface UserProfileRepository extends JpaRepository<UserProfile, String> {

}
