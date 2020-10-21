package com.stackroute.fitnesszone.enquiryservice.service;

import com.stackroute.fitnesszone.enquiryservice.entity.Enquiry;
import com.stackroute.fitnesszone.enquiryservice.exception.EnquiryNotFoundException;
import com.stackroute.fitnesszone.enquiryservice.repository.EnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnquiryServiceImpl implements EnquiryService {

    private EnquiryRepository enquiryRepository;

    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    public EnquiryServiceImpl(EnquiryRepository enquiryRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.enquiryRepository = enquiryRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public Enquiry addNewEnquiry(Enquiry enquiry) {

        Enquiry newEnquiry = enquiryRepository.save(enquiry);
        kafkaTemplate.send("enquiry.topic",newEnquiry.getEnquiryCode());
        return newEnquiry;
    }

    @Override
    public List<Enquiry> listAllEnquiries() {
        return enquiryRepository.findAll();
    }

    @Override
    public Enquiry getEnquiryByCode(String enquiryCode) throws EnquiryNotFoundException {
        if (enquiryRepository.findById(enquiryCode).isEmpty()) {
            throw new EnquiryNotFoundException();
        }
        return enquiryRepository.findById(enquiryCode).get();
    }

}

