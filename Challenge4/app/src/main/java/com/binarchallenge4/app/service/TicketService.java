package com.binarchallenge4.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binarchallenge4.app.model.Ticket;
import com.binarchallenge4.app.repository.TicketRepository;

@Service
public class TicketService {
    
    @Autowired
    TicketRepository ticketRepository;

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket getTicketByUserId(Long id){
        return ticketRepository.findAll().stream().filter(ticket -> ticket.getUserId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    public Ticket getTicketById(Long id){
        return ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
    }


    
}
