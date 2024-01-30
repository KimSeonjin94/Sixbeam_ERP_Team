package com.erpproject.sixbeam.pd.repository;

import com.erpproject.sixbeam.pd.entity.BomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface BomRepository extends JpaRepository<BomEntity, String> {

    @Override
    ArrayList<BomEntity> findAll();
}
