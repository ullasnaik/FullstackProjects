package com.stackroute.fitnesszone.ticketservice.service;

import com.stackroute.fitnesszone.ticketservice.entity.Ticket;
import com.stackroute.fitnesszone.ticketservice.exception.TicketNotFoundException;
import com.stackroute.fitnesszone.ticketservice.exception.UserUnauthorizedException;
import com.stackroute.fitnesszone.ticketservice.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;

    private RestTemplate restTemplate;

    private ResponseEntity responseEntity;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, RestTemplate restTemplate) {
        this.ticketRepository = ticketRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Ticket> listAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> listAllOpenTickets() {
        return ticketRepository.findByIsOpen(true);
    }
    @Override
    public Ticket getTicketByTicketId(String ticketId) throws TicketNotFoundException {
        if (ticketRepository.findById(ticketId).isEmpty()) {
            throw new TicketNotFoundException();
        }
        return ticketRepository.findById(ticketId).get();
    }

    @Override
    public Ticket updateTicket(Ticket ticket) throws TicketNotFoundException, UserUnauthorizedException {
        if (ticketRepository.findById(ticket.getTicketId()).isEmpty()) {
            throw new TicketNotFoundException();
        }

        responseEntity = restTemplate.getForEntity("http://localhost:9000/userservice/api/v1/userservice/" + ticket.getExecutiveEmail(), String.class);
        if (responseEntity.getBody().equals("false")) {
            throw new UserUnauthorizedException();
        }
        return ticketRepository.save(ticket);
    }

}
