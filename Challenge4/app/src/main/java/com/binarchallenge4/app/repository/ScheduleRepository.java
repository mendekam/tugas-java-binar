package com.binarchallenge4.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binarchallenge4.app.model.Schedules;

public interface ScheduleRepository extends JpaRepository<Schedules, Long> {
    
}
