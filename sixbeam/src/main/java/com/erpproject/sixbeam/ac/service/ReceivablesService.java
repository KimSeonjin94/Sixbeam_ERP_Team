package com.erpproject.sixbeam.ac.service;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.repository.AccountRepository;
import com.erpproject.sixbeam.ac.repository.ReceivablesRepository;
import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.repository.InputRepository;
import com.erpproject.sixbeam.pur.repository.OrinPutRepository;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.ss.repository.EstimateRepository;
import com.erpproject.sixbeam.ss.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ReceivablesService {
    private final ReceivablesRepository receivablesRepository;
    private final SaleRepository saleRepository;
    private final EstimateRepository estimateRepository;
    private final AccountRepository accountRepository;

    public Map<String, Integer> sum_input_account(LocalDate startDate, LocalDate endDate){

            int totale=0;
            Map<String,Integer> map= new HashMap<>();
            List<SaleEntity> saleEntities=saleRepository.getSaleListBetweenDates(startDate,endDate);
            for(SaleEntity saleEntity : saleEntities){
                List<EstimateEntity> estimateEntities=estimateRepository.findByEstimateCd(saleEntity.getEstimateCd());
                for(EstimateEntity estimateEntity:estimateEntities){
                    totale=estimateEntity.getEstimateTamt();
                    String accountCd=estimateEntity.getAccountEntity().getAccountCd();
                    if(map.containsKey(accountCd)){
                        map.put(accountCd,map.get(accountCd)+totale);
                    }else{
                        map.put(accountCd,totale);
                    }
                    totale=0;
                }
            }
            return map;
    }
    //회계 반영여부에 따른 거래처별 매출 보여주는 함수
    public int getAccountTotal(String accountCd){
        int total=0;
        AccountEntity accountEntity=accountRepository.findById(accountCd)
                .orElseThrow(() -> new IllegalArgumentException("Invalid account Id:" + accountCd));

        List<EstimateEntity> estimateEntities=estimateRepository.findByAccountEntity(accountEntity);

        for(EstimateEntity estimateEntity:estimateEntities){
            SaleEntity saleEntity=saleRepository.findByEstimateCd(estimateEntity.getEstimateCd())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid estimateCd:" + estimateEntity.getEstimateCd()));
            if(saleEntity.isSaleBillingSt()){
                total+=estimateEntity.getEstimateTamt();
            }
        }
        return total;

    }
}
