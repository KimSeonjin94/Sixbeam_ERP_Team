package com.erpproject.sixbeam.st.service;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.st.entity.CheckEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.repository.CheckRepository;
import com.erpproject.sixbeam.st.repository.WhmoveRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Check;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@RequiredArgsConstructor
@Service
public class CheckService {

    private final CheckRepository checkRepository;

    public int getTotalIncomingCheckAmtByItemAndWhmoveUntilDate(LocalDate whmoveDt, String itemCd, String whmoveCd) {
        return checkRepository.findTotalCheckAmtByWhmoveGbAndItemCdAndWhmoveCdUntilDate("입고", whmoveDt, itemCd, whmoveCd);
    }

    public int getTotalOutgoingCheckAmtByItemAndWhmoveUntilDate(LocalDate whmoveDt, String itemCd, String whmoveCd) {
        return checkRepository.findTotalCheckAmtByWhmoveGbAndItemCdAndWhmoveCdUntilDate("출고", whmoveDt, itemCd, whmoveCd);
    }

    public int getTotalCheckAmtByItemAndWhmoveUntilDate(LocalDate whmoveDt, String itemCd, String whmoveCd) {
        int totalIncoming = getTotalIncomingCheckAmtByItemAndWhmoveUntilDate(whmoveDt, itemCd, whmoveCd);
        int totalOutgoing = getTotalOutgoingCheckAmtByItemAndWhmoveUntilDate(whmoveDt, itemCd, whmoveCd);
        return totalIncoming - totalOutgoing;
    }
}
/*
    private final CheckRepository checkRepository;

    public List<CheckEntity> getList() {
        return this.checkRepository.findAll();
    }

    public int getAmountByDate(WhmoveEntity whmoveEntity, ItemEntity itemEntity, LocalDate date){
    CheckEntity checkEntity = checkRepository.findByWhmoveEntityAndItemEntity(whmoveEntity, itemEntity);
    int currentAmount = checkEntity != null ? checkEntity.getCheckAmt() : 0;
    int totalMovementAmount = checkRepository.countByWhmoveEntityAndItemEntityAndCheckDtBefore(whmoveEntity,itemEntity, date);
    return currentAmount + totalMovementAmount;
    }

    public int getAmountByDate(LocalDate date){
        CheckEntity checkEntity = checkRepository.
    }

}

 */
