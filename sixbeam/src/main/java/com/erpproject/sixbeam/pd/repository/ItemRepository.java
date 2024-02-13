package com.erpproject.sixbeam.pd.repository;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<ItemEntity, String> {

    // 특정 접두사로 시작하는 itemCd를 가진 모든 아이템을 검색하는 메서드
    @Query("SELECT i FROM ItemEntity i WHERE i.itemCd LIKE CONCAT(:prefix, '%')")
    List<ItemEntity> findByItemCdStartingWith(@Param("prefix") String prefix);


}
