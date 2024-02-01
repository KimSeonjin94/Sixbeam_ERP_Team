package com.erpproject.sixbeam.hr.repository;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<EmpInfoEntity,String> {
}
