package com.erpproject.sixbeam.pur.repository;

import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InputRepository extends JpaRepository<InputEntity, String> {

    List<InputEntity> findByinputPurCd(String id);
    boolean existsByOrinputEntity_OrinputCd(String orinputCd);
    @Query("SELECT i.inputSiFl FROM InputEntity i WHERE i.inputPurCd = :inputPurCd")
    boolean checkInputSiFl(@Param("inputPurCd") String inputPurCd);

    @Query("SELECT MAX(i.inputPurCd) FROM InputEntity i WHERE i.inputPurDt = :inputPurDate")
    String getMaxInputCd(@Param("inputPurDate") LocalDate inputPurDate);

    @Query("SELECT i FROM InputEntity i WHERE i.inputPurDt BETWEEN :startDate and :endDate")
    List<InputEntity> findInputByDate(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
