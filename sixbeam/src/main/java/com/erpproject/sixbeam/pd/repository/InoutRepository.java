package com.erpproject.sixbeam.pd.repository;

import com.erpproject.sixbeam.pd.entity.InoutEntity;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InoutRepository extends JpaRepository<InoutEntity, String> {

    List<InoutEntity> findByInoutCmptCd(String inoutCd);

    @Query("SELECT MAX(i.inoutCmptCd) FROM InoutEntity i WHERE i.inoutDt = :inoutDate")
    String getMaxInoutCmptCd(@Param("inoutDate") LocalDate inoutDate);
}
