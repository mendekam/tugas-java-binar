package com.binarchallenge4.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binarchallenge4.app.model.Seat;
import com.binarchallenge4.app.repository.SeatRepository;

@Service
public class SeatService {
    
    @Autowired
    SeatRepository seatRepository;

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public List<Seat> getAllSeat(){
        return seatRepository.findAll();
    }

    public Seat getSeatByNumber(String number){
        return seatRepository.findAll().stream().filter(seat -> seat.getSeatNumber().equals(number)).findFirst().orElseThrow(() -> new RuntimeException("Seat not found"));
    }
    
}
