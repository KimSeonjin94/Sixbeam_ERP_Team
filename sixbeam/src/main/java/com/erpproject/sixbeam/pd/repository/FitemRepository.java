package com.erpproject.sixbeam.pd.repository;

import com.erpproject.sixbeam.pd.entity.FitemEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FitemRepository extends JpaRepository<FitemEntity, ItemEntity> {

}
