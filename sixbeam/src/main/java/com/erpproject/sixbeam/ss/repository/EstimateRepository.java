package com.erpproject.sixbeam.ss.repository;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.EstimateEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface EstimateRepository extends JpaRepository<EstimateEntity, EstimateEntityId> {

    List<EstimateEntity> findByEstimateCd(String id);
    @Query("SELECT MAX(o.estimateCd) FROM EstimateEntity o WHERE o.estimateDt = :estimateDate")
    String getMaxEstimateCd(@Param("estimateDate") LocalDate estimateDate);

    List<EstimateEntity> findByAccountEntity(AccountEntity accountEntity);
}