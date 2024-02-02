package com.erpproject.sixbeam.pd.repository;

import com.erpproject.sixbeam.pd.entity.BomEntity;
import com.erpproject.sixbeam.pd.entity.BomEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface BomRepository extends JpaRepository<BomEntity, BomEntityId> {

    @Override
    ArrayList<BomEntity> findAll();
}
