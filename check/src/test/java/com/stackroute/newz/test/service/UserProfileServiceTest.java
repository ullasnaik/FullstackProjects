package com.stackroute.newz.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.annotation.Rollback;

import com.stackroute.newz.model.UserProfile;
import com.stackroute.newz.repository.UserProfileRepository;
import com.stackroute.newz.service.UserProfileServiceImpl;
import com.stackroute.newz.util.exception.UserProfileAlreadyExistsException;
import com.stackroute.newz.util.exception.UserProfileNotExistsException;

class UserProfileServiceTest {

	@Mock
	private UserProfileRepository userProfileRepository;
	@InjectMocks
	private UserProfileServiceImpl userProfileService;

	private UserProfile userProfile;
	
	private List<UserProfile> userProfiles;

	@BeforeEach
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
		userProfiles = new ArrayList<UserProfile>();
		userProfile = new UserProfile("johnsmith", "John", "Smith", "1234567890", LocalDateTime.now(), null);
		UserProfile userProfile1 = new UserProfile("chrisadler", "Chris", "Adler", "1234567891", LocalDateTime.now(), null);
		UserProfile userProfile2 = new UserProfile("willdavis", "William", "Davis", "1234567892", LocalDateTime.now(), null);
		userProfiles.add(userProfile1);
		userProfiles.add(userProfile2);

	}

	@AfterEach
	public void tearDown() throws Exception {
		userProfile = null;
		userProfiles = null;
	}

	@Test
	@Rollback(true)
	public void testRegisterUserSuccess() throws UserProfileNotExistsException, UserProfileAlreadyExistsException {

		when(userProfileRepository.findById(any())).thenReturn(Optional.empty());
		when(userProfileRepository.save(any())).thenReturn(userProfile);
		userProfileService.registerUser(userProfile);
		assertEquals(userProfile, userProfileService.registerUser(userProfile));

	}

	@Test
	@Rollback(true)
	public void testRegisterUserFailure() throws UserProfileNotExistsException, UserProfileAlreadyExistsException {

		when(userProfileRepository.findById(any())).thenReturn(Optional.of(userProfile));
		assertThrows(UserProfileAlreadyExistsException.class, 
				() -> userProfileService.registerUser(userProfile));

	}
	
	@Test
	@Rollback(true)
	public void testUpdateUserSuccess() throws UserProfileNotExistsException {

		when(userProfileRepository.getOne(any())).thenReturn(userProfile);
		when(userProfileRepository.saveAndFlush(any())).thenReturn(userProfile);
		assertEquals(userProfile, userProfileService.updateUserProfile(userProfile, userProfile.getUserId()));

	}
	
	@Test
	@Rollback(true)
	public void testUpdateUserFailure() throws UserProfileNotExistsException {

		when(userProfileRepository.getOne(any())).thenReturn(null);
		assertThrows(UserProfileNotExistsException.class, 
				() -> userProfileService.updateUserProfile(userProfile,"abc"));
		
	}
	
	@Test
	@Rollback(true)
	public void testDeleteUserSuccess() throws UserProfileNotExistsException {

		when(userProfileRepository.getOne(any())).thenReturn(userProfile);
		userProfileService.deleteUserProfile(userProfile.getUserId());
		verify(userProfileRepository,times(1)).deleteById(any());
	}
	
	@Test
	@Rollback(true)
	public void testDeleteUserFailure() throws UserProfileNotExistsException {

		when(userProfileRepository.getOne(any())).thenReturn(null);
		assertThrows(UserProfileNotExistsException.class, 
				() -> userProfileService.deleteUserProfile(userProfile.getUserId()));
		verify(userProfileRepository,times(0)).deleteById(any());
		
	}
	
	@Test
	@Rollback(true)
	public void testGetUserSuccess() throws UserProfileNotExistsException {

		when(userProfileRepository.findById(any())).thenReturn(Optional.of(userProfile));
		
		assertEquals(userProfile, userProfileService.getUserProfile(userProfile.getUserId()));
		verify(userProfileRepository,times(1)).findById(any());
	}
	
	@Test
	@Rollback(true)
	public void testGetUserFailure() throws UserProfileNotExistsException {

		when(userProfileRepository.findById(any())).thenReturn(Optional.empty());
		assertThrows(UserProfileNotExistsException.class, 
				() -> userProfileService.getUserProfile(userProfile.getUserId()));
		
		verify(userProfileRepository,times(1)).findById(any());
	}
	
	@Test
	@Rollback(true)
	public void testGetAllUsersSuccess() throws UserProfileNotExistsException {

		when(userProfileRepository.findAll()).thenReturn(userProfiles);
		
		assertEquals(userProfiles, userProfileService.getAllUserProfiles());
		verify(userProfileRepository,times(1)).findAll();
	}
	

}
