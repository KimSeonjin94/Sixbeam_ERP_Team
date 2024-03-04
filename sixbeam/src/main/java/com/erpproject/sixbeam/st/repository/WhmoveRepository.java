package com.erpproject.sixbeam.st.repository;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
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

    //List<WhmoveEntity> findByAsEntity(AsEntity asEntity);
    @Query("SELECT c FROM WhmoveEntity c WHERE c.asEntity.asCd = :asCd")
    List<WhmoveEntity> getByasCd(@Param("asCd") String asCd);

}
