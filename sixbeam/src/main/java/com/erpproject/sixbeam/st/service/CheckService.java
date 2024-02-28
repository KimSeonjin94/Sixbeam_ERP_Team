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
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.*;

@RequiredArgsConstructor
@Service
public class CheckService {

    private final CheckRepository checkRepository;
    private final WhmoveRepository whmoveRepository;
    private final WhregistRepository whregistRepository;
    private final ItemRepository itemRepository;


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
    //기준일자의 모든 창고와 품목에 대한 수량 조회------------------------------------------------------------------------------------
    public List<Map<String, Object>> getAllWhItemCheckList(LocalDate date) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<WhregistEntity> allWhregists = getAllWhregists(); // 모든 창고 조회
        List<ItemEntity> allItems = getAllItems(); // 모든 품목 조회
        for (WhregistEntity whregist : allWhregists) {
            for (ItemEntity item : allItems) {
                Map<String, Object> result = new HashMap<>();
                result.put("whregistCd", whregist.getWhregistCd());
                result.put("itemCd", item.getItemCd());
                result.put("currentStock", getTotalWhItemCheckAmt(date, whregist, item));
                resultList.add(result);
            }
        }
        return resultList;
    }
    private List<WhregistEntity> getAllWhregists() {
        return whregistRepository.findAll();
    }
    private List<ItemEntity> getAllItems() {
        return itemRepository.findAll();
    }
    //기준일자의 선택한 창고와 품목에 대한 수량 조회------------------------------------------------------------------------------------
    public List<Map<String, Object>> getAllWhCheckList(LocalDate date, String whregistCd) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        Optional<WhregistEntity> whregistEntity = whregistRepository.findById(whregistCd);
        List<ItemEntity> allItems = getAllItems();
        for (ItemEntity item : allItems) {
            Map<String, Object> result = new HashMap<>();
            result.put("whregistCd", whregistEntity.get().getWhregistCd());
            result.put("itemCd", item.getItemCd());
            result.put("currentStock", getTotalWhItemCheckAmt(date,whregistEntity.get(),item));
            resultList.add(result);
        }
        return resultList;
    }
}
