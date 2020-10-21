package com.stackroute.newz.test.model;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import com.stackroute.newz.model.UserProfile;

class UserProfileTest {

	private UserProfile userProfile;

	@BeforeEach
	public void setUp() throws Exception {
		
		//LocalDateTime localDateTime = LocalDateTime.now();
		
		userProfile = new UserProfile();
		
		userProfile.setUserId("johnsmith");
		userProfile.setFirstName("John");
		userProfile.setLastName("Smith");
		userProfile.setContact("1234567890");
		userProfile.setCreateAt(LocalDateTime.now());
		
	}

	@AfterEach
	public void tearDown() throws Exception {
		
		
	}

	@Test
	public void Beantest() {
		BeanTester beanTester = new BeanTester();
        beanTester.getFactoryCollection().addFactory(LocalDateTime.class, new LocalDateTimeFactory());
        beanTester.testBean(UserProfile.class);


	}

}
