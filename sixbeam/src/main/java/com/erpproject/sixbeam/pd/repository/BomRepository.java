package com.erpproject.sixbeam.pd.repository;

import com.erpproject.sixbeam.pd.entity.*;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import org.hibernate.annotations.processing.Find;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BomRepository extends JpaRepository<BomEntity, BomEntityId> {

    List<BomEntity> findByFitemEntity_ItemCd(String fitemCd);
    List<BomEntity> findByRitemEntity_ItemCd(String ritemCd);
    @Query("SELECT b.bomUseMt FROM BomEntity b WHERE b.ritemEntity.itemCd = :ritemCd AND b.fitemEntity.itemCd = :fitemCd")
    int getBomUseMt(@Param("ritemCd") String ritemCd, @Param("fitemCd") String fitemCd); //원자재 필요 수량 가져와주는 메서드

}
