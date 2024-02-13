package com.erpproject.sixbeam.st.service;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.st.entity.CheckEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.repository.CheckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class CheckService {

    private final CheckRepository checkRepository;

    //통합 조회
    public int getTotalOutgoing(LocalDate whmoveDt) {
        Integer totalOutgoing = checkRepository.findTotalCheck("출고", whmoveDt);
        return totalOutgoing != null ? totalOutgoing.intValue() : 0;
    }

    public int getTotalIncoming(LocalDate whmoveDt) {
        Integer totalIncoming = checkRepository.findTotalCheck("입고", whmoveDt);
        return totalIncoming != null ? totalIncoming.intValue() : 0;
    }

    public int getTotalCheckAmt(LocalDate whmoveDt) {
        Integer totalIncoming = getTotalIncoming(whmoveDt);
        Integer totalOutgoing = getTotalOutgoing(whmoveDt);
        return totalIncoming - totalOutgoing;
    }

    //품목별 조회
    public int getItemIncoming(LocalDate whmoveDt, ItemEntity itemEntity) {
        Integer itemIncoming = checkRepository.findItemCheck("입고", whmoveDt, itemEntity);
        return itemIncoming != null ? itemIncoming.intValue() : 0;
    }

    public int getItemOutgoing(LocalDate whmoveDt, ItemEntity itemEntity) {
        Integer itemOutgoing = checkRepository.findItemCheck("출고", whmoveDt, itemEntity);
        return itemOutgoing != null ? itemOutgoing.intValue() : 0;
    }

    public int getTotalItemCheckAmt(LocalDate whmoveDt, ItemEntity itemEntity) {
        Integer totalItemIncoming = getItemIncoming(whmoveDt, itemEntity);
        Integer totalItemOutgoing = getItemOutgoing(whmoveDt, itemEntity);
        return totalItemIncoming - totalItemOutgoing;
    }

    //창고별 조회
    public int getWhIncoming(LocalDate whmoveDt, WhregistEntity whregistEntity) {
        Integer whIncoming = checkRepository.findWhCheck("입고", whmoveDt, whregistEntity);
        return whIncoming != null ? whIncoming.intValue() : 0;
    }

    public int getWhOutgoing(LocalDate whmoveDt, WhregistEntity whregistEntity) {
        Integer whOutcoming = checkRepository.findWhCheck("출고", whmoveDt, whregistEntity);
        return whOutcoming != null ? whOutcoming.intValue() : 0;
    }

    public int getTotalWhCheckAmt(LocalDate whmoveDt, WhregistEntity whregistEntity) {
        Integer totalWhIncoming = getWhIncoming(whmoveDt, whregistEntity);
        Integer totalWhOutgoing = getWhOutgoing(whmoveDt, whregistEntity);
        return totalWhIncoming - totalWhOutgoing;
    }

    // 원하는 column들만 조회되도록 메서드 수정
    public List<Map<String, Object>> getInventoryByDate(LocalDate date) {
        List<Object[]> inventoryList = checkRepository.findInventoryByDate(date);
        List<Map<String, Object>> result = new ArrayList<>();
        for (Object[] row : inventoryList) {
            Map<String, Object> item = new HashMap<>();
            item.put("whmoveDt", row[0]);
            item.put("whregistCd", row[1]);
            item.put("itemCd", row[2]);
            item.put("checkAmt", row[3]);
            result.add(item);
        }
        return result;
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
