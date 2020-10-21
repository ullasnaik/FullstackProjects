package com.stackroute.newz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.newz.model.Reminder;

/*
* This class is implementing the JpaRepository interface for Reminder.
* Annotate this class with @Repository annotation
* */
@Repository 
public interface ReminderRepository extends  JpaRepository<Reminder,Integer> {

}
