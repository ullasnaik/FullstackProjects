package com.stackroute.newz.service;

import java.util.List;

import com.stackroute.newz.model.UserProfile;
import com.stackroute.newz.util.exception.UserProfileAlreadyExistsException;
import com.stackroute.newz.util.exception.UserProfileNotExistsException;

public interface UserProfileService {

	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */
	public UserProfile registerUser(UserProfile user) throws UserProfileAlreadyExistsException;

	public UserProfile updateUserProfile(UserProfile user, String userId) throws UserProfileNotExistsException;

	public void deleteUserProfile(String userId) throws UserProfileNotExistsException;

	public UserProfile getUserProfile(String userId) throws UserProfileNotExistsException;

	public List<UserProfile> getAllUserProfiles();

}
