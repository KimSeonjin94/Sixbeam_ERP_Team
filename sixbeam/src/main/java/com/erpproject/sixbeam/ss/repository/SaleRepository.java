package com.erpproject.sixbeam.ss.repository;

import com.erpproject.sixbeam.ss.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
@Repository
public interface SaleRepository extends JpaRepository<SaleEntity,String> {
    @Query("SELECT MAX(o.saleCd) FROM SaleEntity o WHERE o.saleUploadDt = :saleDate")
    String getMaxSaleCd(@Param("saleDate") LocalDate saleDate);

    Optional<SaleEntity> findByEstimateCd (String estimateCd);


}
