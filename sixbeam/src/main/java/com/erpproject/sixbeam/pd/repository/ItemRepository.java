package com.erpproject.sixbeam.pd.repository;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<ItemEntity, String> {

    // 특정 접두사로 시작하는 itemCd를 가진 모든 아이템을 검색하는 메서드
    @Query("SELECT i FROM ItemEntity i WHERE i.itemCd LIKE CONCAT(:prefix, '%')")
    List<ItemEntity> findByItemCdStartingWith(@Param("prefix") String prefix);

    // 특정 문자열이 아이템 코드에 포함된 아이템 엔티티를 반환하는 메서드.
    @Query("SELECT i FROM ItemEntity i WHERE i.itemStnd LIKE CONCAT('%', :keyword, '%')")
    List<ItemEntity> findByItemCdContainingKeyword(@Param("keyword") String keyword);

    // ItemEntity 클래스에서 "itemCd" 필드가 "F"로 시작하는 품목 코드들 중에서 최대값을 선택하는 JPQL 쿼리를 사용하여 코드 중 가장 큰 값을 반환
    @Query("SELECT MAX(i.itemCd) FROM ItemEntity i WHERE i.itemCd LIKE 'F%'")
    String getMaxItemCdStartingWithF();
}
