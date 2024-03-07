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

    @Query("SELECT w FROM WhmoveEntity w WHERE w.asEntity = :asEntity")
    WhmoveEntity ByAsCd(@Param("asEntity") AsEntity asEntity);

    @Query("SELECT w FROM WhmoveEntity w WHERE w.saleEntity = :saleEntity")
    List<WhmoveEntity> BySaleCd(@Param("saleEntity") SaleEntity saleEntity);

    @Query("SELECT w FROM WhmoveEntity w WHERE w.inputEntity = :inputEntity")
    WhmoveEntity ByInputCd(@Param("inputEntity") InputEntity inputEntity);

    List<WhmoveEntity> findByAsEntity(AsEntity asEntity);

    List<WhmoveEntity> findBySaleEntity(SaleEntity saleEntity);

    List<WhmoveEntity> findByInputEntity(InputEntity inputEntity);

    @Query("SELECT COALESCE(SUM(c.checkAmt), 0) FROM CheckEntity c " +
            "WHERE YEAR(c.whmoveEntity.whmoveDt) = :year " +
            "AND c.whmoveEntity.whregistEntity = :whregistEntity " +
            "AND c.whmoveEntity.itemEntity = :itemEntity")
    Integer findWhItemCheck(@Param("year") int year,
                            @Param("whregistEntity") WhregistEntity whregistEntity,
                            @Param("itemEntity") ItemEntity itemEntity);

}
