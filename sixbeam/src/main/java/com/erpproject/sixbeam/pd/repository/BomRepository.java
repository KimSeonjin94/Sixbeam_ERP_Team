package com.erpproject.sixbeam.pd.repository;

import com.erpproject.sixbeam.pd.entity.BomEntity;
import com.erpproject.sixbeam.pd.entity.BomEntityId;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import org.hibernate.annotations.processing.Find;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BomRepository extends JpaRepository<BomEntity, BomEntityId> {

    List<BomEntity> findByFitemEntity_ItemCd(String fitemCd);
    List<BomEntity> findByRitemEntity_ItemCd(String ritemCd);
}
