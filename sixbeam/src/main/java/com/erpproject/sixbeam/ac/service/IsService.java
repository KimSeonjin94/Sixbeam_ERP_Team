package com.erpproject.sixbeam.ac.service;

import com.erpproject.sixbeam.ac.entity.BsEntity;
import com.erpproject.sixbeam.ac.entity.IsEntity;
import com.erpproject.sixbeam.ac.repository.IsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IsService {
    private final IsRepository isRepository;

    public IsEntity findIncomeStatementByIsDt(String isDt) {
        return isRepository.findByIsDt(isDt);
    }

    public List<String> findAllIsDts() {
        // 모든 분기 데이터를 조회하는 쿼리 작성
        return isRepository.findAll().stream()
                .map(IsEntity::getIsDt)
                .collect(Collectors.toList());
    }
}
