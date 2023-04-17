package com.binarchallenge4.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binarchallenge4.app.model.Schedules;
import com.binarchallenge4.app.repository.ScheduleRepository;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    public Schedules createSchedule(Schedules schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedules> getAllSchedule() {
        return scheduleRepository.findAll();
    }

    public Schedules getScheduleByFilmId(Long id) {
        return scheduleRepository.findAll().stream().filter(schedule -> schedule.getFilmId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    public Schedules getScheduleById(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    public Schedules updateSchedules(Long id, Schedules schedule) {
        Schedules existingSchedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        try {
            if (schedule.getFilmId() != null && !schedule.getFilmId().equals(""))
                existingSchedule.setFilmId(schedule.getFilmId());
            if (schedule.getDate() != null && !schedule.getDate().equals(""))
                existingSchedule.setDate(schedule.getDate());
            if (schedule.getStartTime() != null && !schedule.getStartTime().equals(""))
                existingSchedule.setStartTime(schedule.getStartTime());
            if (schedule.getEndTime() != null && !schedule.getEndTime().equals(""))
                existingSchedule.setEndTime(schedule.getEndTime());
            if (schedule.getTicketPrice() != null && !schedule.getTicketPrice().equals(""))
                existingSchedule.setTicketPrice(schedule.getTicketPrice());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleRepository.save(existingSchedule);
    }

    public Schedules deleteSchedule(Long id) {
        Schedules existingSchedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        scheduleRepository.delete(existingSchedule);
        return existingSchedule;
    }
}
