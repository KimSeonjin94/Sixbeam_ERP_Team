package com.erpproject.sixbeam.st.repository;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.st.entity.CheckEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CheckRepository extends JpaRepository<CheckEntity, Long> {
    //날짜 및 창고별 Check 테이블 총 재고 조회(품목 구분x)
    @Query("SELECT SUM(c.checkAmt) FROM CheckEntity c WHERE c.whmoveEntity.whmoveGb = :whmoveGb AND c.whmoveEntity.whmoveDt <= :date AND c.whmoveEntity.whregistEntity = :whregistEntity")
    Integer findWhCheck(@Param("whmoveGb") String whmoveGb, @Param("date") LocalDate date, @Param("whregistEntity") WhregistEntity whregistEntity);

    //날짜 및 창고,품목별 Check 테이블 총 재고 조회
    @Query("SELECT SUM(c.checkAmt) FROM CheckEntity c WHERE c.whmoveEntity.whmoveGb = :whmoveGb AND c.whmoveEntity.whmoveDt <= :date AND c.whmoveEntity.whregistEntity = :whregistEntity AND c.whmoveEntity.itemEntity = :itemEntity")
    Integer findWhItemCheck(@Param("whmoveGb") String whmoveGb, @Param("date") LocalDate date, @Param("whregistEntity") WhregistEntity whregistEntity, @Param("itemEntity") ItemEntity itemEntity);

    //이벤트리스너 기본키 생성 메서드
    @Query("SELECT MAX(c.checkCd) FROM CheckEntity c")
    Long getMaxCheckCd();

    //이벤트리스너 delete
//    @Query("SELECT c FROM CheckEntity c WHERE c.whmoveEntity.whmoveCd = :whmoveCd")
//    List<CheckEntity> getBywhmoveCd(@Param("whmoveCd") String whmoveCd);

    //이벤트리스너 update
    @Query("SELECT c FROM CheckEntity c WHERE c.whmoveEntity = :whmoveEntity")
    CheckEntity BywhmoveCd(@Param("whmoveEntity") WhmoveEntity whmoveEntity);


    @Query("SELECT c FROM CheckEntity c WHERE c.whmoveEntity.whmoveCd = :whmoveCd")
    List<CheckEntity> findByWhmoveCd(@Param("whmoveCd") String whmoveCd);
}
