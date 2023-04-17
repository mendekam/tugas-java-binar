package com.binarchallenge4.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binarchallenge4.app.model.Ticket;
import com.binarchallenge4.app.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
  
    @Autowired
    TicketService ticketService;

    @PostMapping("/createTicket")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket ticketList = ticketService.createTicket(ticket);
        return ResponseEntity.ok().body(ticketList);
    }

    @GetMapping("/getTicketByUserId/{userId}")
    public ResponseEntity<Ticket> getTicketByUserId(@PathVariable Long userId) {
        Ticket ticketList = ticketService.getTicketByUserId(userId);
        return ResponseEntity.ok().body(ticketList);
    }

    
}
