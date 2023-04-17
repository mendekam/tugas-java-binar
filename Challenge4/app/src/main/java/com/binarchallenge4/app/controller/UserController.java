package com.binarchallenge4.app.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.binarchallenge4.app.model.Users;
import com.binarchallenge4.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<List<Users>> createUser(@RequestBody List<Users> users) {
        List<Users> listUser = userService.createUser(users);
        return ResponseEntity.ok().body(listUser);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<Users>> getAllUser() {
        List<Users> users = userService.getAllUser();
        return ResponseEntity.ok().body(users); 
    }

    @GetMapping("/getUserByUsername/{username}")
    public ResponseEntity<Users> getUserByUsername(@PathVariable String username) {
        Users users = userService.getUserByUsername(username);
        return ResponseEntity.ok().body(users);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users users) {
        Users user = userService.updateUser(id, users);
        return ResponseEntity.ok().body(user);
    }   
    
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Users> deleteUser(@PathVariable Long id) {
        Users user = userService.deleteUser(id);
        return ResponseEntity.ok().body(user);
    }

}
