package com.erpproject.sixbeam.ss.service;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.repository.AccountRepository;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.ss.dto.EstimateDto;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.ss.repository.EstimateRepository;
import com.erpproject.sixbeam.ss.repository.SaleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RequiredArgsConstructor
@Service
@Slf4j
public class EstimateService {

    private final EstimateRepository estimateRepository;
    private final ItemRepository itemRepository;
    private final AccountRepository accountRepository;
    private final EmpInfoRepository empInfoRepository;
    private final SaleRepository saleRepository;

    //조회
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
                        entity2.setEstimateSp(entity2.getEstimateSp() + entity.getEstimateSp());
                        entity2.setEstimateVat(entity.getEstimateVat() + entity2.getEstimateVat());
                        entity2.setEstimateTamt(entity.getEstimateTamt() + entity2.getEstimateTamt());
                    }

                }
            }
        }
        return deduplicatedList;
    }

    //상세조회
    public List<EstimateEntity> getIdList(String id) {

        return this.estimateRepository.findByEstimateCd(id);
    }

    public Optional<ItemEntity> getItemCd(String id) {
        return this.itemRepository.findById(id);
    }

    //생성
    @Transactional(rollbackFor = Exception.class)
    public void create(List<EstimateDto> estimateDtos) {

        List<EstimateEntity> entities = new ArrayList<>();
        String newEstimateCd = generateNewEstimateCd(estimateDtos.get(0).getEstimateDt());
        for (EstimateDto estimateDto : estimateDtos) {
            EmpInfoEntity empInfoEntity = empInfoRepository.findById(estimateDto.getEmpInfoEntity().getEmpInfoId())
                    .orElseThrow(() -> new EntityNotFoundException("EmpInfo not found"));
            AccountEntity accountEntity = accountRepository.findById(estimateDto.getAccountEntity().getAccountCd())
                    .orElseThrow(() -> new EntityNotFoundException("Account not found"));
            ItemEntity itemEntity = itemRepository.findById(estimateDto.getItemEntity().getItemCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));

            estimateDto.setEmpInfoEntity(empInfoEntity);
            estimateDto.setAccountEntity(accountEntity);
            estimateDto.setItemEntity(itemEntity);
            estimateDto.setEstimateNm(accountEntity.getAccountPic());
            EstimateEntity estimateEntity = estimateDto.toEntity();

            estimateEntity.setEstimateCd(newEstimateCd);
            entities.add(estimateEntity);
        }
        estimateRepository.saveAll(entities);


    }

    //수정
    public void updateAll(List<EstimateDto> estimateDtos) {
        if (saleRepository.findByEstimateCd(estimateDtos.get(0).getEstimateCd()).isPresent()) {
            throw new IllegalStateException("판매 진행이 되어 수정 불가 합니다.");
        }

        for (EstimateDto estimateDto : estimateDtos) {
            // 각 견적 엔티티를 저장 또는 업데이트합니다.
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
            estimateRepository.save(estimateEntity);
        }
    }

    //삭제
    @Transactional
    public void delete(List<String> estimateDtos) {
        List<EstimateEntity> estimateEntityList = new ArrayList<>();
        for (String estimateCd : estimateDtos) {
            Optional<SaleEntity> optionalSaleEntity = saleRepository.findByEstimateCd(estimateCd);
            if (optionalSaleEntity.isPresent()) {
                estimateEntityList.addAll(estimateRepository.findByEstimateCd(estimateCd));
            } else {
                throw new IllegalStateException("판매 진행이 되어 삭제 불가 합니다.");
            }
        }
        estimateRepository.deleteAll(estimateEntityList);
    }

    //기간별 매출 총액 계산하는 함수
    public long getIsNetSales(LocalDate startDate, LocalDate endDate) {
        long total = 0;
        List<SaleEntity> saleEntities = saleRepository.getSaleListBetweenDates(startDate, endDate);
        for (SaleEntity saleEntity : saleEntities) {
            List<EstimateEntity> estimateEntities = estimateRepository.findByEstimateCd(saleEntity.getEstimateCd());
            for (EstimateEntity estimateEntity : estimateEntities) {
                total += estimateEntity.getEstimateTamt();
            }
        }
        return total;

    }

    //거래처별 매출 총액
    public Map<String, Long> getTotalBetweenDates(LocalDate startDate, LocalDate endDate) {
        long totale = 0;
        Map<String, Long> map = new HashMap<>();
        List<SaleEntity> saleEntities = saleRepository.getSaleListBetweenDates(startDate, endDate);
        for (SaleEntity saleEntity : saleEntities) {
            List<EstimateEntity> estimateEntities = estimateRepository.findByEstimateCd(saleEntity.getEstimateCd());
            String accountCd = estimateEntities.get(0).getAccountEntity().getAccountCd();
            for (EstimateEntity estimateEntity : estimateEntities) {
                totale = estimateEntity.getEstimateTamt();
                if (map.containsKey(accountCd)) {
                    map.put(accountCd, map.get(accountCd) + totale);

                } else {
                    map.put(accountCd, totale);
                }
                totale = 0;
            }
        }
        return map;
    }

    //거래처별 월별 금액보여주는 함수 map 으로 리턴 받은거에서 .get("월이름")쓰면 밸류값 받을수 있음
    public Map<String, Long> getTotalBetweenYearDates(String accountCd) {
        long totale = 0;
        Map<String, Long> map = new HashMap<>();
        AccountEntity accountEntity = accountRepository.findById(accountCd)
                .orElseThrow(() -> new EntityNotFoundException("거래처 코드를 찾을 수 없습니다.."));

        List<EstimateEntity> estimateEntities = estimateRepository.findByAccountEntity(accountEntity);
        map.put("Total", totale);
        for (int i = 1; i < 13; i++) {
            map.put(String.valueOf(i), totale);
        }
        for (EstimateEntity estimateEntity : estimateEntities) {
            Optional<SaleEntity> OpSaleEntity = saleRepository.findByEstimateCd(estimateEntity.getEstimateCd());
            if (OpSaleEntity.isEmpty()) {
                break;
            }
            totale = estimateEntity.getEstimateTamt();
            map.put("Total", map.get("Total") + totale);
            if (LocalDate.now().getYear() == estimateEntity.getEstimateDt().getYear()) {
                int month = estimateEntity.getEstimateDt().getMonthValue();
                map.put(String.valueOf(month), map.get(String.valueOf(month)) + totale);
            }
            totale = 0;
        }
        return map;
    }

    //회계 반영여부에 따른 거래처별 매출 보여주는 함수
    public long getAccountTotal(String accountCd) {
        long total = 0;
        AccountEntity accountEntity = accountRepository.findById(accountCd)
                .orElseThrow(() -> new IllegalArgumentException("Invalid account Id:" + accountCd));

        List<EstimateEntity> estimateEntities = estimateRepository.findByAccountEntity(accountEntity);

        for (EstimateEntity estimateEntity : estimateEntities) {
            SaleEntity saleEntity = saleRepository.findByEstimateCd(estimateEntity.getEstimateCd())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid estimateCd:" + estimateEntity.getEstimateCd()));
            if (saleEntity.isSaleBillingSt()) {
                total += estimateEntity.getEstimateTamt();
            }
        }
        return total;

    }

    //새로운 코드 만드는 함수
    private String generateNewEstimateCd(LocalDate estimateDate) {
        // 현재 날짜를 기반으로 새로운 주문 코드 생성
        String prefix = "ES" + estimateDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "-";

        // DB에서 최대 주문 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = estimateRepository.getMaxEstimateCd(estimateDate);
        if (maxCd == null) {
            // 초기값 설정
            maxCd = "0001";
        }
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;

        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%04d", sequenceNumber);

        return prefix + sequenceNumberString;
    }
}


