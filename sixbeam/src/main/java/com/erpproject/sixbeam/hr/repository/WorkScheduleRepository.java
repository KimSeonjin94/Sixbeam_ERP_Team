package com.erpproject.sixbeam.hr.repository;


import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.entity.WorkScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WorkScheduleRepository extends JpaRepository<WorkScheduleEntity,Long> {
    List<WorkScheduleEntity> findByWorkScheduleDate(LocalDate workScheduleDate);
    List<WorkScheduleEntity>findByWorkScheduleDateAndWorkScheduleCheckIsTrue(LocalDate workScheduleDate);
    List<WorkScheduleEntity> findByWorkScheduleDateAndEmpInfoEntity_EmpInfoId(LocalDate workScheduleDate, Long employeeId);
}
