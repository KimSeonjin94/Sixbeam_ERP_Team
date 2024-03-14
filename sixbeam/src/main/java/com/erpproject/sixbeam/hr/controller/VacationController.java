package com.erpproject.sixbeam.hr.controller;
import com.erpproject.sixbeam.home.EventEntity;
import com.erpproject.sixbeam.home.EventService;
import com.erpproject.sixbeam.hr.entity.AttendmgtEntity;
import com.erpproject.sixbeam.hr.service.AttendmgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hr/vacation")
public class VacationController {
    private final AttendmgtService attendmgtService;

    @Autowired
    public VacationController(AttendmgtService attendmgtService) {
        this.attendmgtService = attendmgtService;
    }

    @GetMapping
    public List<AttendmgtEntity> getAllEvents() {
        return attendmgtService.getAllEvents();
    }

    @PostMapping
    public AttendmgtEntity addEvent(@RequestBody AttendmgtEntity event) {
        return attendmgtService.addEvent(event);
    }

    @PutMapping("/{eventId}")
    public AttendmgtEntity updateEvent(@PathVariable("eventId") Long eventId, @RequestBody AttendmgtEntity event) {
        return attendmgtService.updateEvent(event);
    }

    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable("eventId") Long eventId) {
        attendmgtService.deleteEvent(eventId);
    }
}
