package com.erpproject.sixbeam.pur.repository;

import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrinPutRepository extends JpaRepository<OrinPutEntity, String> {
    @Query("SELECT MAX(o.orinputCd) FROM OrinPutEntity o")
    String getMaxOrinputCd();
}
