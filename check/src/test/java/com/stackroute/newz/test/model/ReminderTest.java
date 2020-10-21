package com.stackroute.newz.test.model;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import com.stackroute.newz.model.Reminder;

class ReminderTest {

	private Reminder reminder;

	@BeforeEach
	public void setUp() throws Exception {
		
		reminder = new Reminder();
		
		reminder.setReminderId(1);
		reminder.setSchedule(LocalDateTime.now());
		
		
	}

	@AfterEach
	public void tearDown() throws Exception {
		
		
	}

	@Test
	public void Beantest() {
		BeanTester beanTester = new BeanTester();
        beanTester.getFactoryCollection().addFactory(LocalDateTime.class, new LocalDateTimeFactory());
        beanTester.testBean(Reminder.class);


	}

}
