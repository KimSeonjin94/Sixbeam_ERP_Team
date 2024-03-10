package com.erpproject.sixbeam.pd.repository;

import com.erpproject.sixbeam.pd.entity.InoutEntity;
import com.erpproject.sixbeam.pd.entity.OrderEntity;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InoutRepository extends JpaRepository<InoutEntity, String> {

    InoutEntity findByInoutCmptCd(String inoutCmptCd);

    @Query("SELECT MAX(i.inoutCmptCd) FROM InoutEntity i WHERE i.inoutDt = :inoutDate")
    String getMaxInoutCmptCd(@Param("inoutDate") LocalDate inoutDate);

    @Query("SELECT i FROM InoutEntity i WHERE i.orderEntity.orderSt = false")
    List<InoutEntity> findByOrderStFalse();

    @Modifying
    @Query("DELETE FROM InoutEntity i WHERE i.orderEntity.orderCd = :orderCd")
    void deleteByOrderCd(@Param("orderCd") String orderCd);
}
