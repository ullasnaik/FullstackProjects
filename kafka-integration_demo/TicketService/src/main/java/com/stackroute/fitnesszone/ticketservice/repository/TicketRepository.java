package com.stackroute.fitnesszone.ticketservice.repository;

import com.stackroute.fitnesszone.ticketservice.entity.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {

    List<Ticket> findByIsOpen(boolean open);
}
