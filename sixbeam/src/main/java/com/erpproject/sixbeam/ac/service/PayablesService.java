package com.erpproject.sixbeam.ac.service;

import com.erpproject.sixbeam.ac.entity.BsEntity;
import com.erpproject.sixbeam.ac.repository.BsRepository;
import com.erpproject.sixbeam.ac.repository.PayablesRepository;
import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.repository.InputRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PayablesService {
    private final PayablesRepository payablesRepository;
    private final InputRepository inputRepository;
    private final BsRepository bsRepository;

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

    public void payables_by_year(String yearDate) {
        long sum = 0;
        BsEntity bsEntity = bsRepository.findByBsDt(yearDate);
        //매입 채무 1년 단위로 계산
        List<InputEntity> inputEntityList = inputRepository.findInputByDate(LocalDate.of(Integer.parseInt(yearDate),1,1),LocalDate.of(Integer.parseInt(yearDate),12,31));

        for (InputEntity inputEntity : inputEntityList){
            sum += inputEntity.getOrinputEntity().getOrinputSum();
        }

        bsEntity.setBsPayables(sum);
        bsRepository.save(bsEntity);

    }

}
