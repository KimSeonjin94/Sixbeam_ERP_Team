package com.erpproject.sixbeam.pur.repository;

import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrinPutRepository extends JpaRepository<OrinPutEntity, String> {

    List<OrinPutEntity> findByOrinputCd(String id);

    @Query("SELECT MAX(o.orinputCd) FROM OrinPutEntity o WHERE o.orinputOrDt = :orinputDate")
    String getMaxOrinputCd(@Param("orinputDate")LocalDate orinputDate);

    @Query("SELECT o FROM OrinPutEntity o WHERE NOT EXISTS (SELECT i FROM InputEntity i WHERE i.orinputEntity.orinputCd = o.orinputCd)")
    List<OrinPutEntity> findByInputComplete();
}
