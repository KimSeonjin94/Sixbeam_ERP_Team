package com.erpproject.sixbeam.hr.repository;


import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpInfoRepository extends JpaRepository<EmpInfoEntity,Long> {
    Optional<EmpInfoEntity> findByEmpInfoId(Long empInfoId);
}
