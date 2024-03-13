package com.erpproject.sixbeam.hr.repository;

import com.erpproject.sixbeam.hr.entity.AttendmgtEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendmgtRepository extends JpaRepository<AttendmgtEntity,Long> {
    List<AttendmgtEntity> findByEmpInfoEntity_EmpInfoId(Long empInfoId);
}
