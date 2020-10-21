package com.sr.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.sr.model.Customer;


public interface CustomerRepository extends MongoRepository<Customer, String> {

	Customer findBy_id(ObjectId _id);
	

	

}
