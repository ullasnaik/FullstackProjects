package com.stackroute.fitnesszone.enquiryservice.service;

import com.stackroute.fitnesszone.enquiryservice.entity.Enquiry;
import com.stackroute.fitnesszone.enquiryservice.exception.EnquiryNotFoundException;

import java.util.List;

public interface EnquiryService {

    Enquiry addNewEnquiry(Enquiry enquiry);

    List<Enquiry> listAllEnquiries();

    Enquiry getEnquiryByCode(String enquiryCode) throws EnquiryNotFoundException;

}
