package com.erpproject.sixbeam.st.repository;

import com.erpproject.sixbeam.st.entity.AsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AsRepository extends JpaRepository<AsEntity,String> {
    @Query("SELECT MAX(a.asCd) FROM AsEntity a WHERE a.asDt = :asDate")
    String getMaxAsCd(@Param("asDate") LocalDate asDate);

}
