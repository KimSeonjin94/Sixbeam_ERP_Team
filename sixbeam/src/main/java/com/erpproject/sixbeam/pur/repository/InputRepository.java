package com.erpproject.sixbeam.pur.repository;

import com.erpproject.sixbeam.pur.entity.InputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface InputRepository extends JpaRepository<InputEntity, String> {
    boolean existsByOrinputEntity_OrinputCd(String orinputCd);

    @Query("SELECT MAX(i.inputPurCd) FROM InputEntity i WHERE i.inputPurDt = :inputPurDate")
    String getMaxInputCd(@Param("inputPurDate") LocalDate inputPurDate);
}
