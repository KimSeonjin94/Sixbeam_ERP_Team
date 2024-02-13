package com.erpproject.sixbeam.pd.repository;

import com.erpproject.sixbeam.pd.entity.FitemEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.RitemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RitemRepository extends JpaRepository<RitemEntity, String> {

}
