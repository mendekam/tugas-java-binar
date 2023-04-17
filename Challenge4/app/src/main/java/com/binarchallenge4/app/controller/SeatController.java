package com.binarchallenge4.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binarchallenge4.app.model.Seat;
import com.binarchallenge4.app.service.SeatService;

@RestController
@RequestMapping("/seat")
public class SeatController {
    
    @Autowired
    SeatService seatService;

    @PostMapping("/createSeat")
    public ResponseEntity<Seat> createSeat(@RequestBody Seat seat) {
        Seat seatList = seatService.createSeat(seat);
        return ResponseEntity.ok().body(seatList);
    }

    @GetMapping("/getAllSeat")
    public ResponseEntity<List<Seat>> getAllSeat() {
        List<Seat> seat = seatService.getAllSeat();
        return ResponseEntity.ok().body(seat); 
    }

    @GetMapping("/getSeatByNumber/{number}")
    public ResponseEntity<Seat> getSeatByNumber(@PathVariable String number) {
        Seat seat = seatService.getSeatByNumber(number);
        return ResponseEntity.ok().body(seat);
    }
}
