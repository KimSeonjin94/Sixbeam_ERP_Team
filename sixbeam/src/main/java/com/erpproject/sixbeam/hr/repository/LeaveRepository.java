package com.erpproject.sixbeam.hr.repository;


import com.erpproject.sixbeam.hr.entity.LeaveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<LeaveEntity,String> {
}
