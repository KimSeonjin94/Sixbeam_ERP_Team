package com.erpproject.sixbeam.pd.repository;

import com.erpproject.sixbeam.pd.entity.BomEntity;
import com.erpproject.sixbeam.pd.entity.BomEntityId;
import com.erpproject.sixbeam.pd.entity.FitemEntity;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import org.hibernate.annotations.processing.Find;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BomRepository extends JpaRepository<BomEntity, BomEntityId> {

    List<BomEntity> findByFitemEntity_ItemCd(String fitemCd);
    List<BomEntity> findByRitemEntity_ItemCd(String ritemCd);

}
