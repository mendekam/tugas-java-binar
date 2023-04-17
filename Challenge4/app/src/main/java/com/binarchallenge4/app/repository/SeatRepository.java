package com.binarchallenge4.app.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.binarchallenge4.app.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    //List<Seat> findBySeatNumber(String seatNumber, Pageable pageable);
}
