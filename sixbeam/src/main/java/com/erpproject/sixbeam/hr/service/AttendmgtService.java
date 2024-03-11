package com.erpproject.sixbeam.hr.service;

import com.erpproject.sixbeam.hr.entity.AttendmgtEntity;
import com.erpproject.sixbeam.hr.repository.AttendmgtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttendmgtService {
    private final AttendmgtRepository attendmgtRepository;

    @Autowired
    public AttendmgtService(AttendmgtRepository attendmgtRepository) {
        this.attendmgtRepository = attendmgtRepository;
    }

    public AttendmgtEntity addEvent(AttendmgtEntity event) {
        return attendmgtRepository.save(event);
    }

    public AttendmgtEntity updateEvent(AttendmgtEntity event) {
        return attendmgtRepository.save(event);
    }

    public void deleteEvent(Long eventId) {
        attendmgtRepository.deleteById(eventId);
    }

    public List<AttendmgtEntity> getAllEvents() {
        return attendmgtRepository.findAll();
    }
}
