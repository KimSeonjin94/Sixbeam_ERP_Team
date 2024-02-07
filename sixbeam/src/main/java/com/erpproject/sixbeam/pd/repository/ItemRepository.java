package com.erpproject.sixbeam.pd.repository;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, String> {

    List<ItemEntity> findByItemCd(String id);

}
