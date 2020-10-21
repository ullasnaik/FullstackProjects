package com.stackroute.fitnesszone.ticketservice.service;

import com.stackroute.fitnesszone.ticketservice.entity.Ticket;
import com.stackroute.fitnesszone.ticketservice.exception.TicketNotFoundException;
import com.stackroute.fitnesszone.ticketservice.exception.UserUnauthorizedException;

import java.util.List;

public interface TicketService {

    List<Ticket> listAllTickets();

    List<Ticket> listAllOpenTickets();

    Ticket getTicketByTicketId(String ticketId) throws TicketNotFoundException;

    Ticket updateTicket(Ticket ticket) throws TicketNotFoundException, UserUnauthorizedException;
}
