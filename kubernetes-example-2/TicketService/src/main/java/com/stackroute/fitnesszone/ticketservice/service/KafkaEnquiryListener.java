package com.stackroute.fitnesszone.ticketservice.service;

import com.stackroute.fitnesszone.ticketservice.entity.Ticket;
import com.stackroute.fitnesszone.ticketservice.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaEnquiryListener implements EnquiryListener {

    private TicketRepository ticketRepository;

    @Autowired
    public KafkaEnquiryListener(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @KafkaListener(topics = "enquiry-topic")
    @Override
    public void addNewTicket(String enquiryCode) {

        Ticket ticket = new Ticket();
        ticket.setEnquiryCode(enquiryCode);
        ticket.setOpen(true);

        ticketRepository.save(ticket);
    }
}
