package com.stackroute.userprofile.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.userprofile.model.UserProfile;
import com.stackroute.userprofile.repository.UserProfileRepository;
import com.stackroute.userprofile.util.exception.UserProfileAlreadyExistsException;
import com.stackroute.userprofile.util.exception.UserProfileNotFoundException;

/*
* Service classes are used here to implement additional business logic/validation 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesn't currently 
* provide any additional behavior over the @Component annotation, but it's a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */
@Service
public class UserProfileServiceImpl implements UserProfileService {

	/*
	 * Autowiring should be implemented for the UserProfileRepository. (Use
	 * Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */
	
	private UserProfileRepository userProfileRepository;
	
	private static final String USER_NOT_EXISTS = "User does not exists";
	private static final String USER_ALREADY_EXISTS= "User already exists";
	
	
	@Autowired
	public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
		this.userProfileRepository = userProfileRepository;
	}
	

	/*
	 * This method should be used to save a new userprofile.Call the corresponding method
	 * of Respository interface.
	 */

	public UserProfile registerUser(UserProfile user) throws UserProfileAlreadyExistsException {
		
		UserProfile userProfile = null;
		
		boolean existingUserCheck = userProfileRepository.existsById(user.getUserId());
        
		if (existingUserCheck) {
            throw new UserProfileAlreadyExistsException(USER_ALREADY_EXISTS);
        } else {
            user.setCreatedAt();
            userProfile = userProfileRepository.insert(user);
            if (userProfile == null) {
                throw new UserProfileAlreadyExistsException(USER_ALREADY_EXISTS);
            }
        }
        return userProfile;
    }

	/*
	 * This method should be used to update a existing userprofile.Call the corresponding
	 * method of Respository interface.
	 */

    @Override
    public UserProfile updateUser(String userId, UserProfile user) throws UserProfileNotFoundException {
    	
    	try {
        	UserProfile userProfile = null;	
        	Optional<UserProfile> fetchedUserProfile = userProfileRepository.findById(userId);
        	
        	if(fetchedUserProfile.isPresent()) {
        		userProfile = fetchedUserProfile.get();
        		userProfile.setFirstName(user.getFirstName());
        		userProfile.setLastName(user.getLastName());
        		userProfile.setEmail(user.getEmail());
        		userProfile.setContact(user.getContact());
            	userProfileRepository.save(userProfile);
            }
            return userProfile;
        } catch (Exception e) {
            throw new UserProfileNotFoundException(USER_NOT_EXISTS);
        }
    }

	/*
	 * This method should be used to delete an existing user. Call the corresponding
	 * method of Respository interface.
	 */

    @Override
    public boolean deleteUser(String userId) throws UserProfileNotFoundException {
    	
    	boolean deleteStatus = false;
        try {
        	UserProfile userProfile = null;
        	Optional<UserProfile> fetchedUserProfile = userProfileRepository.findById(userId);
        	
        	if(fetchedUserProfile.isPresent()) {
        		userProfile = fetchedUserProfile.get();
            	if (userProfile != null) {
            		userProfileRepository.delete(userProfile);
            		deleteStatus = true;
                }
        	}
        } catch (Exception e) {
            throw new UserProfileNotFoundException(USER_NOT_EXISTS);
        }
        return deleteStatus;
    }
    
	/*
	 * This method should be used to get userprofile by userId.Call the corresponding
	 * method of Respository interface.
	 */

    @Override
    public UserProfile getUserById(String userId) throws UserProfileNotFoundException {
    	
    	UserProfile userProfile = null;
    	Optional<UserProfile> fetchedUserProfile = userProfileRepository.findById(userId);
    	
    	if(fetchedUserProfile.isPresent()) {
    		userProfile = fetchedUserProfile.get();
    
	        if (userProfile == null) {
	            throw new UserProfileNotFoundException(USER_NOT_EXISTS);
	        }
    	}
    	return userProfile;
    }
}
