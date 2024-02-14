package com.erpproject.sixbeam.st.service;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.st.entity.CheckEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.repository.CheckRepository;
import com.erpproject.sixbeam.st.repository.WhmoveRepository;
import com.erpproject.sixbeam.st.repository.WhregistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@RequiredArgsConstructor
@Service
public class CheckService {

    private final CheckRepository checkRepository;
    private final WhmoveRepository whmoveRepository;

    //통합 조회------------------------------------------------------------------------------
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

    //품목별 조회------------------------------------------------------------------------------
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

    //창고별 조회------------------------------------------------------------------------------
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

    //창고,품목별 조회------------------------------------------------------------------------------
    public int getWhItemIncoming(LocalDate whmoveDt, WhregistEntity whregistEntity, ItemEntity itemEntity) {
        Integer whItemIncoming = checkRepository.findWhItemCheck("입고", whmoveDt, whregistEntity, itemEntity);
        return whItemIncoming != null ? whItemIncoming.intValue() : 0;
    }

    public int getWhItemOutgoing(LocalDate whmoveDt, WhregistEntity whregistEntity, ItemEntity itemEntity) {
        Integer whItemOutcoming = checkRepository.findWhItemCheck("출고", whmoveDt, whregistEntity, itemEntity);
        return whItemOutcoming != null ? whItemOutcoming.intValue() : 0;
    }

    public int getTotalWhItemCheckAmt(LocalDate whmoveDt, WhregistEntity whregistEntity, ItemEntity itemEntity) {
        Integer totalWhItemIncoming = getWhItemIncoming(whmoveDt, whregistEntity, itemEntity);
        Integer totalWhItemOutgoing = getWhItemOutgoing(whmoveDt, whregistEntity, itemEntity);
        return totalWhItemIncoming - totalWhItemOutgoing;
    }


    // 원하는 column들만 조회되도록 메서드 수정
    public List<Map<String, Object>> getCheckByDate(LocalDate date) {
        List<Object[]> CheckList = checkRepository.findCheckByDate(date);
        List<Map<String, Object>> result = new ArrayList<>();
        for (Object[] row : CheckList) {
            Map<String, Object> item = new HashMap<>();
            item.put("whmoveDt", row[0]);
            item.put("whregistCd", row[1]);
            item.put("itemCd", row[2]);
            item.put("checkAmt", row[3]);
            result.add(item);
        }
        return result;
    }

    // 원하는 column들만 조회되도록 메서드 수정
    public List<Map<String, Object>> getChecktest(LocalDate date) {
        List<WhmoveEntity> whmoveEntities = whmoveRepository.findByWhmoveDt(date);
        List<Map<String, Object>> result = new ArrayList<>();
        for (WhmoveEntity whmoveEntity : whmoveEntities) {
            WhregistEntity whregistEntity = whmoveEntity.getWhregistEntity();
            ItemEntity itemEntity = whmoveEntity.getItemEntity();

            Integer i = checkRepository.findWhItemCheck("입고", date, whregistEntity, itemEntity);
            int result1 = (i != null) ? i.intValue() : 0;
            Integer o = checkRepository.findWhItemCheck("출고", date, whregistEntity, itemEntity);
            int result2 = (o != null) ? o.intValue() : 0;

            List<Object[]> checkList = checkRepository.findtest("입고", date, whregistEntity, itemEntity);
            List<Map<String, Object>> innerResult = new ArrayList<>(); // 내부 결과 리스트

            for (Object[] row : checkList) {
                Long checkAmt = (Long) row[3]; // 해당 행의 checkAmt 값을 가져옴
                int outgoingAmount = getOutgoingAmount(date, whregistEntity, itemEntity); // 출고량 가져오기
                int result3 = 0; // 기본값 설정

                if (checkAmt != null) {
                    result3 = checkAmt.intValue() - outgoingAmount; // 해당 행의 결과3 값을 계산
                }

                Map<String, Object> item = new HashMap<>();
                item.put("whmoveDt", row[0]);
                item.put("whregistCd", row[1]);
                item.put("itemCd", row[2]);
                item.put("checkAmt", checkAmt);
                item.put("result3", result3); // 결과3 값을 맵에 추가
                innerResult.add(item);
            }

            result.addAll(innerResult); // 내부 결과를 외부 결과에 추가
        }
        return result; // 최종 결과 반환
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
