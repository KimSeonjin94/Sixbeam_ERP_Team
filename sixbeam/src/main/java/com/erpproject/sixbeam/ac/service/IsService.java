package com.erpproject.sixbeam.ac.service;

import com.erpproject.sixbeam.ac.entity.BsEntity;
import com.erpproject.sixbeam.ac.entity.IsEntity;
import com.erpproject.sixbeam.ac.repository.IsRepository;
import com.erpproject.sixbeam.ss.service.EstimateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IsService {
    private final IsRepository isRepository;
    private final EstimateService estimateService;
    public IsEntity findIncomeStatementByIsDt(String isDt) {
        return isRepository.findByIsDt(isDt);
    }

    public List<String> findAllIsDts() {
        // 모든 분기 데이터를 조회하는 쿼리 작성
        return isRepository.findAll().stream()
                .map(IsEntity::getIsDt)
                .collect(Collectors.toList());
    }
    public void updateIsNetSales(String isDt){
        Optional<IsEntity> opIsEntity=isRepository.findById(isDt);
        LocalDate startDate=LocalDate.now();
        LocalDate endDate=LocalDate.now();
        int year= Integer.parseInt(isDt.substring(0,4));

        startDate = LocalDate.of(year, 1, 1);
        endDate = LocalDate.of(year, 12, LocalDate.of(year, 12, 1).lengthOfMonth());


        long isNetSales=0;
        isNetSales= estimateService.getIsNetSales(startDate,endDate);
        if(opIsEntity.isPresent()){
            IsEntity isEntity=opIsEntity.get();
            isEntity.setIsNetSales(isNetSales);
            isRepository.save(isEntity);
        }
    }
}
