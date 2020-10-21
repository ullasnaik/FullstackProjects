package com.stackroute.fitnesszone.ticketservice.entity;

import org.springframework.data.annotation.Id;

public class Ticket {

    @Id
    private String ticketId;

    private String EnquiryCode;

    private boolean isOpen;

    private String remarks;

    private String executiveEmail;

    public Ticket() {
    }

    public Ticket(String enquiryCode, boolean isOpen, String remarks, String executiveEmail) {

        EnquiryCode = enquiryCode;
        this.isOpen = isOpen;
        this.remarks = remarks;
        this.executiveEmail = executiveEmail;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getEnquiryCode() {
        return EnquiryCode;
    }

    public void setEnquiryCode(String enquiryCode) {
        EnquiryCode = enquiryCode;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getExecutiveEmail() {
        return executiveEmail;
    }

    public void setExecutiveEmail(String executiveEmail) {
        this.executiveEmail = executiveEmail;
    }

}

