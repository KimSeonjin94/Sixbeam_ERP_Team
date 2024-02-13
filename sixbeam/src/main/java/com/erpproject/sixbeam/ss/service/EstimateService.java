package com.erpproject.sixbeam.ss.service;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.repository.AccountRepository;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.ss.dto.EstimateDto;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.repository.EstimateRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RequiredArgsConstructor
@Service
public class EstimateService {

    private final EstimateRepository estimateRepository;
    private final ItemRepository itemRepository;
    private final AccountRepository accountRepository;
    private final EmpInfoRepository empInfoRepository;

    public List<EstimateEntity> getList() {
        List<EstimateEntity> estimateEntities = estimateRepository.findAll();
        // 중복된 estimateCd를 저장할 Set
        Set<String> uniqueEstimateCds = new HashSet<>();

        // 중복 제거된 EstimateEntity 리스트
        List<EstimateEntity> deduplicatedList = new ArrayList<>();

        // 중복을 제거하면서 리스트를 생성
        for (EstimateEntity entity : estimateEntities) {
            if (uniqueEstimateCds.add(entity.getEstimateCd())) {
                // estimateCd가 추가되지 않았으면 중복이므로 추가하지 않음
                deduplicatedList.add(entity);
            } else {
                for (EstimateEntity entity2 : deduplicatedList) {
                    if (entity.getEstimateCd().equals(entity2.getEstimateCd())) {
                        entity2.setEstimateSp(entity2.getEstimateSp()+entity.getEstimateSp());
                        entity2.setEstimateVat(entity.getEstimateVat()+entity2.getEstimateVat());
                        entity2.setEstimateTamt(entity.getEstimateTamt()+entity2.getEstimateTamt());
                    }

                }
            }
        }
        return deduplicatedList;
    }

    public List<EstimateEntity> getIdList(String id) {

        return this.estimateRepository.findByEstimateCd(id);
    }

    public Optional<ItemEntity> getItemCd(String id) {
        return this.itemRepository.findById(id);
    }

    public void create(List<EstimateDto> estimateDtos) {
        List<EstimateEntity> entities = new ArrayList<>();
        String newEstimateCd = generateNewEstimateCd();
        for (EstimateDto estimateDto : estimateDtos) {
            EmpInfoEntity empInfoEntity = empInfoRepository.findById(estimateDto.getEmpInfoEntity().getEmpInfoId())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            AccountEntity accountEntity = accountRepository.findById(estimateDto.getAccountEntity().getAccountCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            ItemEntity itemEntity = itemRepository.findById(estimateDto.getItemEntity().getItemCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));

            estimateDto.setEmpInfoEntity(empInfoEntity);
            estimateDto.setAccountEntity(accountEntity);
            estimateDto.setItemEntity(itemEntity);
            EstimateEntity estimateEntity = estimateDto.toEntity();

            estimateEntity.setEstimateCd(newEstimateCd);
            entities.add(estimateEntity);
        }
        estimateRepository.saveAll(entities);

    }
    private String generateNewEstimateCd() {
        // 현재 날짜를 기반으로 새로운 주문 코드 생성
        String prefix = "ES" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "-";

        // DB에서 최대 주문 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = estimateRepository.getMaxEstimateCd();
        if (maxCd == null) {
            // 초기값 설정
            maxCd = "1001";
        }
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;

        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%03d", sequenceNumber);

        return prefix + sequenceNumberString;
    }
}


