package com.erpproject.sixbeam.st.service;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.repository.AccountRepository;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.st.event.WhmoveRowAddedEvent;
import com.erpproject.sixbeam.st.dto.AsDto;
import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.event.WhmoveRowDeletedEvent;
import com.erpproject.sixbeam.st.event.WhmoveRowUpdatedEvent;
import com.erpproject.sixbeam.st.repository.AsRepository;
import com.erpproject.sixbeam.st.repository.WhregistRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AsService {

    private final ApplicationEventPublisher addEvent;
    private final ApplicationEventPublisher deleteEvent;
    private final ApplicationEventPublisher updateEvent;
    private final AsRepository asRepository;
    private final ItemRepository itemRepository;
    private final AccountRepository accountRepository;
    private final EmpInfoRepository empInfoRepository;
    private final WhregistRepository whregistRepository;

    public List<AsEntity> getList() {
        return this.asRepository.findAll();
    }

    public List<AsEntity> getIdList(String id) {
        return this.asRepository.findByAsCd(id);
    }

    public void create(List<AsDto> asDtos) {
        for (AsDto asDto : asDtos) {
            EmpInfoEntity empInfoEntity = empInfoRepository.findById(asDto.getEmpInfoEntity().getEmpInfoId())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            AccountEntity accountEntity = accountRepository.findById(asDto.getAccountEntity().getAccountCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            ItemEntity itemEntity = itemRepository.findById(asDto.getItemEntity().getItemCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            WhregistEntity whregistEntity = whregistRepository.findById(asDto.getWhregistEntity().getWhregistCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            String newAsCd = generateNewAsCd(asDto.getAsDt());
            asDto.setEmpInfoEntity(empInfoEntity);
            asDto.setAccountEntity(accountEntity);
            asDto.setItemEntity(itemEntity);
            asDto.setWhregistEntity(whregistEntity);
            AsEntity asEntity = asDto.toEntity();
            asEntity.setAsCd(newAsCd);
            asRepository.save(asEntity);
            WhmoveRowAddedEvent<AsEntity> asEvent = new WhmoveRowAddedEvent<>(this, asEntity);
            addEvent.publishEvent(asEvent);
        }
    }

    public void updateAll(AsDto asDto) {
            EmpInfoEntity empInfoEntity = empInfoRepository.findById(asDto.getEmpInfoEntity().getEmpInfoId())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            AccountEntity accountEntity = accountRepository.findById(asDto.getAccountEntity().getAccountCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            ItemEntity itemEntity = itemRepository.findById(asDto.getItemEntity().getItemCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            WhregistEntity whregistEntity = whregistRepository.findById(asDto.getWhregistEntity().getWhregistCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            asDto.setEmpInfoEntity(empInfoEntity);
            asDto.setAccountEntity(accountEntity);
            asDto.setItemEntity(itemEntity);
            asDto.setWhregistEntity(whregistEntity);
            AsEntity asEntity = asDto.toEntity();
            asRepository.save(asEntity);
            WhmoveRowUpdatedEvent<AsEntity> asEvent = new WhmoveRowUpdatedEvent<>(this, asEntity);
            updateEvent.publishEvent(asEvent);
    }
    @Transactional
    public void delete(List<String> asCds) {
        List<AsEntity> asEntitiesToDelete = new ArrayList<>();
        for (String asCd : asCds) {
            List<AsEntity> asEntities = asRepository.findByAsCd(asCd);
            asEntitiesToDelete.addAll(asEntities);
            asRepository.deleteAll(asEntities);
        }
        WhmoveRowDeletedEvent<AsEntity> asDeletedEvent = new WhmoveRowDeletedEvent<>(this, asEntitiesToDelete);
        deleteEvent.publishEvent(asDeletedEvent);
    }
    private String generateNewAsCd(LocalDate asDate) {
        // 현재 날짜를 기반으로 새로운 주문 코드 생성
        String prefix = "AS" + asDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "-";
        // DB에서 최대 주문 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = asRepository.getMaxAsCd(asDate);
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;
        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%04d", sequenceNumber);
        return prefix + sequenceNumberString;
    }
}

