package com.erpproject.sixbeam.pur.service;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.repository.AccountRepository;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.repository.OrinPutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrinPutService {
    private final OrinPutRepository orinPutRepository;
    private final AccountRepository accountRepository;
    private final EmpInfoRepository empInfoRepository;
    private final ItemRepository itemRepository;

    public List<OrinPutEntity> getList() {
        return this.orinPutRepository.findAll();
    }

    public List<AccountEntity> getactList() {
        return this.accountRepository.findAll();
    }

    public List<EmpInfoEntity> getemplist(){
        return this.empInfoRepository.findAll();
    }

    public List<ItemEntity> getitemlist() {
        return this.itemRepository.findAll();
    }

    public void save(OrinPutEntity orinPutEntity) {
        // 새로운 주문 코드 생성
        String newOrinputCd = generateNewOrinputCd();
        orinPutEntity.setOrinputCd(newOrinputCd);

        // 엔티티 저장
        orinPutRepository.save(orinPutEntity);
    }

    private String generateNewOrinputCd() {
        // 현재 날짜를 기반으로 새로운 주문 코드 생성
        String prefix = "OR" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")) + "-";

        // DB에서 최대 주문 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = orinPutRepository.getMaxOrinputCd();
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;

        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%04d", sequenceNumber);

        return prefix + sequenceNumberString;
    }
}
