package com.erpproject.sixbeam.st.service;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.st.entity.CheckEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.event.CheckRowDeletedEvent;
import com.erpproject.sixbeam.st.event.WhmoveRowDeletedEvent;
import com.erpproject.sixbeam.st.repository.CheckRepository;
import com.erpproject.sixbeam.st.repository.WhmoveRepository;
import com.erpproject.sixbeam.st.repository.WhregistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.*;

@RequiredArgsConstructor
@Service
public class
CheckService {

    private final CheckRepository checkRepository;
    private final WhregistRepository whregistRepository;
    private final ItemRepository itemRepository;
    private final ApplicationEventPublisher eventPublisher;

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
                result.put("whregistNm", whregist.getWhregistNm());
                result.put("itemNm", item.getItemNm());
                result.put("itemStnd", item.getItemStnd());
                result.put("currentStock", getTotalWhItemCheckAmt(date, whregist, item));
                long calcul = item.getItemUp() * getTotalWhItemCheckAmt(date,whregist,item);
                result.put("calcul", calcul);
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
            result.put("whregistNm", whregistEntity.get().getWhregistNm());
            result.put("itemNm", item.getItemNm());
            result.put("itemStnd", item.getItemStnd());
            result.put("currentStock", getTotalWhItemCheckAmt(date,whregistEntity.get(),item));
            long calcul = item.getItemUp() * getTotalWhItemCheckAmt(date,whregistEntity.get(),item);
            result.put("calcul", calcul);
            resultList.add(result);
        }
        return resultList;
    }
    public void addRowCheck(WhmoveEntity whmoveEntity) {
        CheckEntity checkEntity = new CheckEntity();
        Long newCheckCd = generateNewCheckCd();
        checkEntity.setCheckCd(newCheckCd);
        checkEntity.setWhmoveEntity(whmoveEntity);
        checkEntity.setCheckAmt(whmoveEntity.getWhmoveAmt());
        long calculated = whmoveEntity.getWhmoveAmt() * whmoveEntity.getItemEntity().getItemUp();
        checkRepository.save(checkEntity);
    }
    private Long generateNewCheckCd() {
        Long beforeCd = checkRepository.getMaxCheckCd();
        Long sequenceNumber = beforeCd + 1;
        return sequenceNumber;
    }
    public void deleteRowCheck(WhmoveEntity whmoveEntity) {
        // WhmoveEntity에 대한 삭제 로직 수행 후
        CheckRowDeletedEvent<WhmoveEntity> whmoveDeletedEvent = new CheckRowDeletedEvent<>(this, whmoveEntity);
        eventPublisher.publishEvent(whmoveDeletedEvent);
    }

    //호진 형님 이거 갖다가 쓰세용~
    //    public List<CheckEntity> dataForYear(int year) {
//        return checkRepository.findByWhmoveEntity_WhmoveDtYear(year);
//    }
//    public Map<Integer, Object> getSumByYear(int year) {
//        List<WhregistEntity> allWhregists = getAllWhregists(); // 모든 창고 조회
//        List<ItemEntity> allItems = getAllItems(); // 모든 품목 조회
//        List<CheckEntity> a = this.dataForYear(year);
//        for (WhregistEntity whregist : allWhregists) {
//            for (ItemEntity item : allItems) {
//                Map<String, Object> result = new HashMap<>();
//                result.put("whregistCd", whregist.getWhregistCd());
//                result.put("itemNm", item.getItemCd());
//                if (a.get(0).getWhmoveEntity().getWhmoveGb() == "입고") {
//
//                }
//                result.put("currentStock", getTotalWhItemCheckAmt(date, whregist, item));
//            }
//        }
//    }

}
