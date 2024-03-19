package com.erpproject.sixbeam.ac.service;

import com.erpproject.sixbeam.ac.entity.BsEntity;
import com.erpproject.sixbeam.ac.entity.IsEntity;
import com.erpproject.sixbeam.ac.repository.BsRepository;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pur.repository.OrinPutRepository;
import com.erpproject.sixbeam.ss.service.EstimateService;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.repository.WhmoveRepository;
import com.erpproject.sixbeam.st.repository.WhregistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BsService {
    private final BsRepository bsRepository;
    private final WhmoveRepository whmoveRepository;
    private final WhregistRepository whregistRepository;
    private final ItemRepository itemRepository;

    public BsEntity findBalanceSheetByBsDt(String bsDt) {
        return bsRepository.findByBsDt(bsDt);
    }

    public List<String> findAllBsDts() {
        // 모든 분기 데이터를 조회하는 쿼리 작성
        return bsRepository.findAll().stream()
                .map(BsEntity::getBsDt)
                .collect(Collectors.toList());
    }

    private final EstimateService estimateService;

    public void updateBsReceivables(String bsDt) {
        Optional<BsEntity> OpBsEntity = bsRepository.findById(bsDt);
        if (OpBsEntity.isPresent()) {
            int year = Integer.parseInt(bsDt.substring(0, 4));

            LocalDate startDate = LocalDate.of(year, 1, 1);
            LocalDate endDate = LocalDate.of(year, 12, LocalDate.of(year, 12, 1).lengthOfMonth());


            long sum = estimateService.getIsNetSales(startDate, endDate);


            BsEntity bsEntity = OpBsEntity.get();
            bsEntity.setBsReceivables(sum);
            bsRepository.save(bsEntity);
        }
    }

    public void updateBsInventoriesByYear(String bsDt) { //재고자산 계산
        int year = Integer.parseInt(bsDt);
        long totalPayable = 0;
        LocalDate endDate = LocalDate.of(year, Month.DECEMBER, 31);
        List<WhregistEntity> allWhregists = whregistRepository.findAll();
        List<ItemEntity> allItems = itemRepository.findAll();
        for (WhregistEntity whregist : allWhregists) {
            for (ItemEntity item : allItems) {
                int currentStock = getTotalWhItemCheckAmtByYear(year, endDate, whregist, item);
                totalPayable += item.getItemUp() * currentStock;
            }
        }
        bsRepository.updateBsInventories(bsDt, totalPayable);
    }

    private int getTotalWhItemCheckAmtByYear(int year, LocalDate endDate, WhregistEntity whregist, ItemEntity item) {
        return whmoveRepository.findWhItemCheckByYear(endDate, whregist, item);
    }

}

