package com.erpproject.sixbeam.ss.repository;

import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.EstimateEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstimateRepository extends JpaRepository<EstimateEntity, EstimateEntityId> {

    List<EstimateEntity> findById(String id);
}