package com.erpproject.sixbeam.pur.repository;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.entity.OrinPutEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrinPutRepository extends JpaRepository<OrinPutEntity, OrinPutEntityId> {

    List<OrinPutEntity> findByOrinputCd(String id);

    @Query("SELECT MAX(o.orinputCd) FROM OrinPutEntity o WHERE o.orinputOrDt = :orinputDate")
    String getMaxOrinputCd(@Param("orinputDate")LocalDate orinputDate);
}
