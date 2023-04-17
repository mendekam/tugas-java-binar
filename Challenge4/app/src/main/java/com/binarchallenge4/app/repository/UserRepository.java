package com.binarchallenge4.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binarchallenge4.app.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    
}
