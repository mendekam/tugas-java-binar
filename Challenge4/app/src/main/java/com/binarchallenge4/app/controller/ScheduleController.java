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

import com.binarchallenge4.app.model.Schedules;
import com.binarchallenge4.app.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    
    @Autowired
    ScheduleService scheduleService;

    @PostMapping("/createSchedule")
    public ResponseEntity<Schedules> createSchedule(@RequestBody Schedules schedule) {
        Schedules scheduleList = scheduleService.createSchedule(schedule);
        return ResponseEntity.ok().body(scheduleList);
    }

    @GetMapping("/getAllSchedule")
    public ResponseEntity<List<Schedules>> getAllSchedule() {
        List<Schedules> schedule = scheduleService.getAllSchedule();
        return ResponseEntity.ok().body(schedule); 
    }

    @GetMapping("/getScheduleByFilmId/{filmId}")
    public ResponseEntity<Schedules> getScheduleByFilmId(@PathVariable Long filmId) {
        Schedules schedule = scheduleService.getScheduleByFilmId(filmId);
        return ResponseEntity.ok().body(schedule);
    }

    @PutMapping("/updateSchedule/{id}")
    public ResponseEntity<Schedules> updateSchedules(@PathVariable Long id, @RequestBody Schedules schedule) {
        Schedules scheduleList = scheduleService.updateSchedules(id, schedule);
        return ResponseEntity.ok().body(scheduleList);
    }

    @DeleteMapping("/deleteSchedule/{id}")
    public ResponseEntity<Schedules> deleteSchedule(@PathVariable Long id) {
        Schedules schedule = scheduleService.deleteSchedule(id);
        return ResponseEntity.ok().body(schedule);
    }
}
