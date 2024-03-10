package com.erpproject.sixbeam.st.repository;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WhmoveRepository extends JpaRepository<WhmoveEntity,String> {
    List<WhmoveEntity> findByWhmoveDt(LocalDate date);

    @Query("SELECT c.whmoveEntity.whmoveDt, c.whmoveEntity.whregistEntity.whregistCd, c.whmoveEntity.itemEntity.itemCd, " +
            "(SELECT SUM(c.checkAmt) FROM CheckEntity c WHERE c.whmoveEntity.whmoveGb = :whmoveGb AND c.whmoveEntity.whmoveDt <= :date AND c.whmoveEntity.whregistEntity = :whregistEntity AND c.whmoveEntity.itemEntity = :itemEntity) as Amt FROM CheckEntity c WHERE c.whmoveEntity.whmoveDt = :date")
    List<Object[]> findtest(@Param("date") LocalDate date, @Param("whregistEntity") WhregistEntity whregistEntity, @Param("itemEntity") ItemEntity itemEntity);

    @Query("SELECT MAX(w.whmoveCd) FROM WhmoveEntity w WHERE w.whmoveDt = :whmoveDate")
    String getMaxWhmoveCd(@Param("whmoveDate") LocalDate whmoveDate);

    @Query("SELECT w FROM WhmoveEntity w WHERE w.asCd = :asCd")
    WhmoveEntity ByAsCd(@Param("asCd") String asCd);

    @Query("SELECT w FROM WhmoveEntity w WHERE w.saleCd = :saleCd")
    WhmoveEntity BySaleCd(@Param("saleCd") String saleCd);

    @Query("SELECT w FROM WhmoveEntity w WHERE w.inputPurCd = :inputPurCd")
    WhmoveEntity ByInputCd(@Param("inputPurCd") String inputPurCd);

    List<WhmoveEntity> findByAsCd(String asCd);

    List<WhmoveEntity> findBySaleCd(String saleCd);

    List<WhmoveEntity> findByInputPurCd(String InputPurCd);

    @Query("SELECT COALESCE(SUM(CASE WHEN c.whmoveEntity.whmoveGb = '입고' THEN c.checkAmt ELSE -c.checkAmt END), 0) FROM CheckEntity c " +
            "WHERE c.whmoveEntity.whmoveDt <= :endDate " +
            "AND c.whmoveEntity.whregistEntity = :whregistEntity " +
            "AND c.whmoveEntity.itemEntity = :itemEntity")
    Integer findWhItemCheckByYear(
            @Param("endDate") LocalDate endDate,
            @Param("whregistEntity") WhregistEntity whregistEntity,
            @Param("itemEntity") ItemEntity itemEntity
    );

}
