package com.erpproject.sixbeam.hr.service;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.entity.WorkScheduleEntity;
import com.erpproject.sixbeam.hr.repository.WorkScheduleRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
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
    public void uudateAttendmgtsearch(Long workScheduleCd,
                                      EmpInfoEntity empInfoId,
                                      boolean workScheduleCheck,
                                      LocalDate workScheduleDate,
                                      LocalTime workScheduleStartTime,
                                      LocalTime workScheduleEndTime,
                                      String workScheduleReason){
        WorkScheduleEntity workScheduleEntity=new WorkScheduleEntity();
        workScheduleEntity.setWorkScheduleCd(workScheduleCd);
        workScheduleEntity.setEmpInfoEntity(empInfoId);
        workScheduleEntity.setWorkScheduleCheck(workScheduleCheck);
        workScheduleEntity.setWorkScheduleDate(workScheduleDate);
        workScheduleEntity.setWorkScheduleStartTime(workScheduleStartTime);
        workScheduleEntity.setWorkScheduleEndTime(workScheduleEndTime);
        workScheduleEntity.setWorkScheduleReason(workScheduleReason);
        workScheduleRepository.save(workScheduleEntity);
    }
}
