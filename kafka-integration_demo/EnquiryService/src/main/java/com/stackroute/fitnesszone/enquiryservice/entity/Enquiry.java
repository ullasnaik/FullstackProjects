package com.stackroute.fitnesszone.enquiryservice.entity;

import org.springframework.data.annotation.Id;

public class Enquiry {

    @Id
    private String enquiryCode;
    private String name;
    private String email;
    private String mobile;
    private String query;

    public Enquiry(String name, String email, String mobile, String query) {

        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.query = query;
    }

    public Enquiry() {
    }

    public String getEnquiryCode() {
        return enquiryCode;
    }

    public void setEnquiryCode(String enquiryCode) {
        this.enquiryCode = enquiryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}

