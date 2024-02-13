package com.erpproject.sixbeam.st.repository;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.st.entity.CheckEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CheckRepository extends JpaRepository<CheckEntity, Long> {

    @Query("SELECT SUM(c.checkAmt) FROM CheckEntity c WHERE c.whmoveEntity.whmoveGb = :whmoveGb AND c.whmoveEntity.whmoveDt <= :date AND c.itemEntity.itemCd = :itemCd AND c.whmoveEntity.whmoveCd = :whmoveCd")
    int findTotalCheckAmtByWhmoveGbAndItemCdAndWhmoveCdUntilDate(@Param("whmoveGb") String whmoveGb, @Param("date") LocalDate date, @Param("itemCd") String itemCd, @Param("whmoveCd") String whmoveCd);

}
    /*
    int findTotalCheckAmtByWhmoveGbUntilDate(String whmoveGb, LocalDate whmoveDt);



}
/*
    List<CheckEntity> findByWhmoveEntityWhmoveDtBefore(LocalDate whmoveDt);

    List<CheckEntity> findByWhmoveEntityWhmoveDt(LocalDate whmoveDt);

    default int findTotalCheckAmtUntilDate(LocalDate whmoveDt) {
        List<CheckEntity> recordsUntilDate = findByWhmoveEntityWhmoveDtBefore(whmoveDt);
        return recordsUntilDate.stream()
                .mapToInt(CheckEntity::getCheckAmt)
                .sum();
    }


}
    /*
    CheckEntity findByWhmoveEntityAndItemEntity(WhmoveEntity whmoveEntity, ItemEntity itemEntity);

    int countByWhmoveEntityAndItemEntityAndCheckDtBefore(WhmoveEntity whmoveEntity, ItemEntity itemEntity, LocalDate date);


     */
