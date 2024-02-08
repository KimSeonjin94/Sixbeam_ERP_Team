package com.erpproject.sixbeam.st.repository;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.st.entity.CheckEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CheckRepository extends JpaRepository<CheckEntity,String> {
    CheckEntity findByWhmoveEntityAndItemEntity(WhmoveEntity whmoveEntity, ItemEntity itemEntity);

    int countByWhmoveEntityAndItemEntityAndCheckDtBefore(WhmoveEntity whmoveEntity, ItemEntity itemEntity, LocalDate date);
}
