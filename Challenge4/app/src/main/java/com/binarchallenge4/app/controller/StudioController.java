package com.binarchallenge4.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binarchallenge4.app.model.Studios;
import com.binarchallenge4.app.service.StudioService;

@RestController
@RequestMapping("/studio")
public class StudioController {
    
    @Autowired
    StudioService studioService;

    @PostMapping("/createStudio")
    public ResponseEntity<Studios> createStudio(@RequestBody Studios studio) {
        Studios studioList = studioService.createStudio(studio);
        return ResponseEntity.ok().body(studioList);
    }

    @GetMapping("/getAllStudio")
    public ResponseEntity<List<Studios>> getAllStudio() {
        List<Studios> studio = studioService.getAllStudio();
        return ResponseEntity.ok().body(studio); 
    }

    @GetMapping("/getStudioById/{id}")
    public ResponseEntity<Studios> getStudioById(@PathVariable Long id) {
        Studios studio = studioService.getStudioById(id);
        return ResponseEntity.ok().body(studio);
    }

    @PutMapping("/updateStudio/{id}")
    public ResponseEntity<Studios> updateStudio(@PathVariable Long id, @RequestBody Studios studio) {
        Studios studioList = studioService.updateStudio(id, studio);
        return ResponseEntity.ok().body(studioList);
    }

    @DeleteMapping("/deleteStudio/{id}")
    public ResponseEntity<Studios> deleteStudio(@PathVariable Long id) {
        Studios studio = studioService.deleteStudio(id);
        return ResponseEntity.ok().body(studio);
    }
    
}
