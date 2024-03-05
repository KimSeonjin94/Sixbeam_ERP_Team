package com.erpproject.sixbeam.ac.service;

import com.erpproject.sixbeam.ac.repository.ReceivablesRepository;
import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.repository.InputRepository;
import com.erpproject.sixbeam.pur.repository.OrinPutRepository;
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
    private final InputRepository inputRepository;
    private final OrinPutRepository orinPutRepository;

    public Map<String, Integer> sum_input_account(LocalDate startDate, LocalDate endDate){
        int sum = 0;
        String accountCode = null;
        Map<String, Integer> accountBySum = new HashMap<>();
        List<InputEntity> inputEntityList = this.inputRepository.findInputByDate(startDate,endDate);
        OrinPutEntity orinPutEntity = null;

        for(InputEntity inputEntity : inputEntityList){
            accountCode = inputEntity.getOrinputEntity().getAccountEntity().getAccountCd();

            sum = inputEntity.getOrinputEntity().getOrinputSum();

            if(accountBySum.containsKey(accountCode)) {
                accountBySum.put(accountCode, accountBySum.get(accountCode)+sum);
            }else{
                accountBySum.put(accountCode, sum);
            }
            sum=0;
        }

        return accountBySum;
    }
}
