package com.erpproject.sixbeam.ac.service;

import com.erpproject.sixbeam.ac.entity.BsEntity;
import com.erpproject.sixbeam.ac.repository.BsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

}

