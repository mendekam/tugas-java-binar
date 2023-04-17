package com.binarchallenge4.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binarchallenge4.app.model.Studios;

public interface StudioRepository extends JpaRepository<Studios, Long> {
    
}
