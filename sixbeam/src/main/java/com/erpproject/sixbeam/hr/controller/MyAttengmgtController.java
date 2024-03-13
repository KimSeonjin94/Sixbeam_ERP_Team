package com.erpproject.sixbeam.hr.controller;
import com.erpproject.sixbeam.home.EventEntity;
import com.erpproject.sixbeam.home.EventService;
import com.erpproject.sixbeam.hr.entity.AttendmgtEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.hr.service.AttendmgtService;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendmgt")
public class MyAttengmgtController {
    private final AttendmgtService attendmgtService;
    private final EmpInfoRepository empInfoRepository;

    public MyAttengmgtController(AttendmgtService attendmgtService, EmpInfoRepository empInfoRepository) {
        this.attendmgtService = attendmgtService;
        this.empInfoRepository = empInfoRepository;
    }

    @GetMapping
    public List<AttendmgtEntity> getAllEvents() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Long empInfoId = Long.parseLong(username);
        return attendmgtService.getEventsByEmpInfoId(empInfoId);
    }

    @PostMapping
    public AttendmgtEntity addEvent(@RequestBody AttendmgtEntity event) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Long empInfoId = Long.parseLong(username);
        Optional<EmpInfoEntity> emp = empInfoRepository.findByEmpInfoId(empInfoId);
        EmpInfoEntity empp = emp.get();
        event.setEmpInfoEntity(empp);
        return attendmgtService.addEvent(event);
    }

    @PutMapping("/{eventId}")
    public AttendmgtEntity updateEvent(@PathVariable("eventId") Long eventId, @RequestBody AttendmgtEntity event) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Long empInfoId = Long.parseLong(username);
        Optional<EmpInfoEntity> emp = empInfoRepository.findByEmpInfoId(empInfoId);
        EmpInfoEntity empp = emp.get();
        event.setEmpInfoEntity(empp);
        return attendmgtService.updateEvent(event);
    }

    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable("eventId") Long eventId) {
        attendmgtService.deleteEvent(eventId);
    }
}


