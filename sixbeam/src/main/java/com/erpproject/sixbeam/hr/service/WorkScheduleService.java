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
    public List<WorkScheduleEntity> findByDateAndCheckTrue(LocalDate selectedDate) {
        return this.workScheduleRepository.findByWorkScheduleDateAndWorkScheduleCheckIsTrue(selectedDate);
    }
    public void updateReasonForWorkSchedule(LocalDate workScheduleDate, Long empInfoId, String workScheduleReason) {
        List<WorkScheduleEntity> workSchedules = workScheduleRepository.findByWorkScheduleDateAndEmpInfoEntity_EmpInfoId(workScheduleDate, empInfoId);

        for (WorkScheduleEntity workSchedule : workSchedules) {
            workSchedule.setWorkScheduleReason(workScheduleReason);
            // 다른 업데이트 로직 추가 가능
        }

        // 업데이트된 데이터를 저장
        workScheduleRepository.saveAll(workSchedules);
    }
}
