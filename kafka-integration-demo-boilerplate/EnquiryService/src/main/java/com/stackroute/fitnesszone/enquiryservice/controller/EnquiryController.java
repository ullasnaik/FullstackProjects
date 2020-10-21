package com.stackroute.fitnesszone.enquiryservice.controller;

import com.stackroute.fitnesszone.enquiryservice.entity.Enquiry;
import com.stackroute.fitnesszone.enquiryservice.exception.EnquiryNotFoundException;
import com.stackroute.fitnesszone.enquiryservice.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/enquiryservice")
public class EnquiryController {

    private EnquiryService enquiryService;


    @Autowired
    public EnquiryController(EnquiryService enquiryService) {
        this.enquiryService = enquiryService;
    }

    @GetMapping("/admin/")
    public ResponseEntity<?> listAllEnquiries() {
        return new ResponseEntity<>(enquiryService.listAllEnquiries(), HttpStatus.OK);
    }

    @GetMapping("/admin/{enquiryCode}")
    public ResponseEntity<?> getEnquiryByCode(@PathVariable String enquiryCode) throws EnquiryNotFoundException {
        return new ResponseEntity<>(enquiryService.getEnquiryByCode(enquiryCode), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> addNewEnquiry(@RequestBody Enquiry enquiry) {
        return new ResponseEntity<>(enquiryService.addNewEnquiry(enquiry), HttpStatus.CREATED);
    }

}
