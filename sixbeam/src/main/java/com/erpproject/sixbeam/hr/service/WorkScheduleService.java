package com.erpproject.sixbeam.hr.service;

import com.erpproject.sixbeam.hr.entity.WorkScheduleEntity;
import com.erpproject.sixbeam.hr.repository.WorkScheduleRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkScheduleService {
    private final WorkScheduleRepository workScheduleRepository;
    public List<WorkScheduleEntity>getList(){return this.workScheduleRepository.findAll();}
    public List<WorkScheduleEntity> findByDate(LocalDate selectedDate) {
        return this.workScheduleRepository.findByWorkScheduleDate(selectedDate);
    }
}
