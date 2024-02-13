package com.erpproject.sixbeam.ss.repository;

import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.EstimateEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstimateRepository extends JpaRepository<EstimateEntity, EstimateEntityId> {

    List<EstimateEntity> findByEstimateCd(String id);
    @Query("SELECT MAX(o.estimateCd) FROM EstimateEntity o")
    String getMaxEstimateCd();
}