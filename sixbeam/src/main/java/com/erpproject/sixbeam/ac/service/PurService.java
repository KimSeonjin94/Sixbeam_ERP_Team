package com.erpproject.sixbeam.ac.service;

import com.erpproject.sixbeam.ac.entity.PurEntity;
import com.erpproject.sixbeam.ac.repository.PurRepository;
import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.repository.InputRepository;
import com.erpproject.sixbeam.pur.repository.OrinPutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PurService {
    private final PurRepository purRepository;
    private final InputRepository inputRepository;
    private final OrinPutRepository orinPutRepository;

    public List<PurEntity> getList() {
        return this.purRepository.findAll();
    }

    public Map<String, Object> sum_input_account(){

        String accountCode = null;
        Map<String, Object> accountBySum = new HashMap<>();
        List<InputEntity> inputEntityList = this.inputRepository.findAll();
        List<OrinPutEntity> orinPutEntityList = null;

        for(InputEntity inputEntity : inputEntityList){
            accountCode = inputEntity.getOrinputEntity().getAccountEntity().getAccountCd();
            orinPutEntityList = this.orinPutRepository.findByaccountCd(accountCode);
            int sum = 0;
            for(OrinPutEntity orinPutEntity : orinPutEntityList){
                sum += orinPutEntity.getOrinputSum();
            }
            accountBySum.put(accountCode, sum);
        }

        return accountBySum;
    }
}
