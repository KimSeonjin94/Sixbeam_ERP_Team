package com.erpproject.sixbeam.st.repository;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.st.entity.AsEntity;
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
    //날짜별 Check 테이블 총 재고 조회(아이템, 창고 구분x)
    @Query("SELECT SUM(c.checkAmt) FROM CheckEntity c WHERE c.whmoveEntity.whmoveGb = :whmoveGb AND c.whmoveEntity.whmoveDt <= :date")
    Integer findTotalCheck(@Param("whmoveGb") String whmoveGb, @Param("date") LocalDate date);

    //날짜 및 품목별 Check 테이블 총 재고 조회(창고 구분x)
    @Query("SELECT SUM(c.checkAmt) FROM CheckEntity c WHERE c.whmoveEntity.whmoveGb = :whmoveGb AND c.whmoveEntity.whmoveDt <= :date AND c.whmoveEntity.itemEntity = :itemEntity")
    Integer findItemCheck(@Param("whmoveGb") String whmoveGb, @Param("date") LocalDate date, @Param("itemEntity") ItemEntity itemEntity);

    //날짜 및 창고별 Check 테이블 총 재고 조회(품목 구분x)
    @Query("SELECT SUM(c.checkAmt) FROM CheckEntity c WHERE c.whmoveEntity.whmoveGb = :whmoveGb AND c.whmoveEntity.whmoveDt <= :date AND c.whmoveEntity.whregistEntity = :whregistEntity")
    Integer findWhCheck(@Param("whmoveGb") String whmoveGb, @Param("date") LocalDate date, @Param("whregistEntity") WhregistEntity whregistEntity);

    //날짜 및 창고,품목별 Check 테이블 총 재고 조회
    @Query("SELECT SUM(c.checkAmt) FROM CheckEntity c WHERE c.whmoveEntity.whmoveGb = :whmoveGb AND c.whmoveEntity.whmoveDt <= :date AND c.whmoveEntity.whregistEntity = :whregistEntity AND c.whmoveEntity.itemEntity = :itemEntity")
    Integer findWhItemCheck(@Param("whmoveGb") String whmoveGb, @Param("date") LocalDate date, @Param("whregistEntity") WhregistEntity whregistEntity, @Param("itemEntity") ItemEntity itemEntity);

    // 원하는 column들만 조회되도록 쿼리 메서드 수정
    @Query("SELECT c.whmoveEntity.whmoveDt, c.whmoveEntity.whregistEntity.whregistCd, c.whmoveEntity.itemEntity.itemCd, c.checkAmt FROM CheckEntity c WHERE c.whmoveEntity.whmoveDt = :date")
    List<Object[]> findCheckByDate(@Param("date") LocalDate date);

    //test
    @Query("SELECT c.whmoveEntity.whmoveDt, c.whmoveEntity.whregistEntity.whregistCd, c.whmoveEntity.itemEntity.itemCd, " +
            "(SELECT SUM(c.checkAmt) FROM CheckEntity c WHERE c.whmoveEntity.whmoveGb = :whmoveGb AND c.whmoveEntity.whmoveDt <= :date AND c.whmoveEntity.whregistEntity = :whregistEntity AND c.whmoveEntity.itemEntity = :itemEntity) as Amt FROM CheckEntity c WHERE c.whmoveEntity.whmoveDt = :date")
    List<Object[]> findtest(@Param("date") LocalDate date, @Param("whregistEntity") WhregistEntity whregistEntity, @Param("itemEntity") ItemEntity itemEntity);

    //기본키 생성 메서드
    @Query("SELECT MAX(c.checkCd) FROM CheckEntity c")
    Long getMaxCheckCd();

    @Query("SELECT c FROM CheckEntity c WHERE c.whmoveEntity.whmoveCd = :whmoveCd")
    List<CheckEntity> getBywhmoveCd(@Param("whmoveCd") String whmoveCd);

    @Query("SELECT c FROM CheckEntity c WHERE c.whmoveEntity = :whmoveEntity")
    CheckEntity BywhmoveCd(@Param("whmoveEntity") WhmoveEntity whmoveEntity);


}
