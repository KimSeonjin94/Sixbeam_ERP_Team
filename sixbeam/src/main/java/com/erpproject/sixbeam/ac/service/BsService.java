package com.erpproject.sixbeam.ac.service;

import com.erpproject.sixbeam.ac.entity.BsEntity;
import com.erpproject.sixbeam.ac.entity.IsEntity;
import com.erpproject.sixbeam.ac.repository.BsRepository;
import com.erpproject.sixbeam.ss.service.EstimateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BsService {
    private final BsRepository bsRepository;

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

    public void updateBsReceivables(String bsDt){
        Optional<BsEntity> OpBsEntity=bsRepository.findById(bsDt);
        int year= Integer.parseInt(bsDt.substring(0,4));

        LocalDate startDate=LocalDate.of(year,1,1);
        LocalDate endDate=LocalDate.of(year,12, LocalDate.of(year, 12, 1).lengthOfMonth());



        int sum=estimateService.getIsNetSales(startDate,endDate);

        if(OpBsEntity.isPresent()){
            BsEntity bsEntity=OpBsEntity.get();
            bsEntity.setBsReceivables(sum);
            bsRepository.save(bsEntity);
        }
    }

}

