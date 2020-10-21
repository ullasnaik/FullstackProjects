package com.stackroute.fitnesszone.enquiryservice.repository;

import com.stackroute.fitnesszone.enquiryservice.entity.Enquiry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryRepository extends MongoRepository<Enquiry, String> {

}