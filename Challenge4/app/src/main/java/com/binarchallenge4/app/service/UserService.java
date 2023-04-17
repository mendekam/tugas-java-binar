package com.binarchallenge4.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binarchallenge4.app.model.Users;
import com.binarchallenge4.app.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<Users> createUser(List<Users> users) {
        return userRepository.saveAll(users);
    }

    public List<Users> getAllUser() {
        return userRepository.findAll();
    }

    public Users getUserByUsername(String username) {
        return userRepository.findAll().stream().filter(user -> user.getUsername().equals(username))
                .findFirst().orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Users updateUser(Long id, Users user) {
        Users existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        try {
            if (user.getUsername() != null && !user.getUsername().equals(""))
                existingUser.setUsername(user.getUsername());
            if (user.getPassword() != null && !user.getPassword().equals(""))
                existingUser.setPassword(user.getPassword());
            if (user.getEmail() != null && !user.getEmail().equals(""))
                existingUser.setEmail(user.getEmail());
        } catch (Exception e) {
            System.err.println(e);
        }
        return userRepository.save(existingUser);
    }

    public Users deleteUser(Long id) {
        Users existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(existingUser);
        return existingUser;
    }
}
