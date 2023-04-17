package com.binarchallenge4.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binarchallenge4.app.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
}
