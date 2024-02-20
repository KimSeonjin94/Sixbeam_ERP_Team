package com.erpproject.sixbeam.pur.service;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.repository.AccountRepository;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pur.dto.OrinPutDto;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.repository.InputRepository;
import com.erpproject.sixbeam.pur.repository.OrinPutRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrinPutService {
    private final OrinPutRepository orinPutRepository;
    private final InputRepository inputRepository;
    private final AccountRepository accountRepository;
    private final EmpInfoRepository empInfoRepository;
    private final ItemRepository itemRepository;

    public List<OrinPutEntity> getList() {
        return this.orinPutRepository.findAll();
    }

    public List<AccountEntity> getactList() {
        return this.accountRepository.findAccountCdByEtc("구매처");
    }

    public List<EmpInfoEntity> getemplist(){
        return this.empInfoRepository.findAll();
    }

    public List<ItemEntity> getitemlist() {
        return this.itemRepository.findAll();
    }

    public List<OrinPutEntity> getIdList(String id) {

        return this.orinPutRepository.findByOrinputCd(id);
    }

    public void updateAll(List<OrinPutDto> orinPutDtos){
        for (OrinPutDto orinputDto : orinPutDtos) {
            // 각 견적 엔티티를 저장 또는 업데이트합니다.
            EmpInfoEntity empInfoEntity = empInfoRepository.findById(orinputDto.getEmpInfoEntity().getEmpInfoId())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            AccountEntity accountEntity = accountRepository.findById(orinputDto.getAccountEntity().getAccountCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            ItemEntity itemEntity = itemRepository.findById(orinputDto.getItemEntity().getItemCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));

            orinputDto.setEmpInfoEntity(empInfoEntity);
            orinputDto.setAccountEntity(accountEntity);
            orinputDto.setItemEntity(itemEntity);
            OrinPutEntity orinPutEntity = orinputDto.toEntity();
            orinPutRepository.save(orinPutEntity);
        }
    }
    public void save(List<OrinPutDto> orinPutDtos) {
        //List<OrinPutEntity> entities = new ArrayList<>();
        for (OrinPutDto orinputDto : orinPutDtos) {
            EmpInfoEntity empInfoEntity = empInfoRepository.findById(orinputDto.getEmpInfoEntity().getEmpInfoId())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            AccountEntity accountEntity = accountRepository.findById(orinputDto.getAccountEntity().getAccountCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            ItemEntity itemEntity = itemRepository.findById(orinputDto.getItemEntity().getItemCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));

            orinputDto.setEmpInfoEntity(empInfoEntity);
            orinputDto.setAccountEntity(accountEntity);
            orinputDto.setItemEntity(itemEntity);

            OrinPutEntity orinPutEntity = orinputDto.toEntity();
            String newOrinputCd = generateNewOrinputCd(orinputDto.getOrinputOrDt());
            orinPutEntity.setOrinputCd(newOrinputCd);
            //entities.add(orinPutEntity);
            orinPutRepository.save(orinPutEntity);
        }
        //orinPutRepository.saveAll(entities);
    }

    private String generateNewOrinputCd(LocalDate orinputDate) {
        // 현재 날짜를 기반으로 새로운 주문 코드 생성
        String prefix = "OR" + orinputDate.format(DateTimeFormatter.ofPattern("yyMMdd")) + "-";

        // DB에서 최대 주문 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = orinPutRepository.getMaxOrinputCd(orinputDate);
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;

        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%04d", sequenceNumber);

        return prefix + sequenceNumberString;
    }

    @Transactional
    public void delete(List<String> orinputIds) {
        for (String orinputId : orinputIds) {
            // ORINPUT_CD를 참조하는 InputEntity가 있는지 확인
            boolean isReferenced = inputRepository.existsByOrinputEntity_OrinputCd(orinputId);
            if (isReferenced) {
                // ORINPUT_CD를 참조하는 엔티티가 존재하면 삭제를 거부
                throw new IllegalStateException("구매 진행이 되어 삭제 불가 합니다.");
            } else {
                // ORINPUT_CD를 참조하는 엔티티가 없으면 삭제를 진행
                List<OrinPutEntity> orinPutEntities = orinPutRepository.findByOrinputCd(orinputId);
                orinPutRepository.deleteAll(orinPutEntities);
            }
        }
    }
}
