package com.erpproject.sixbeam.pd.repository;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, String> {
}
