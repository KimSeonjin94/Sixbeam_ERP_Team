package com.erpproject.sixbeam.pd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BomService {
    private final EmpInfoRepository empInfoRepository;

    public List<EmpInfoEntity> getList(){
        return this.empInfoRepository.findAll();
    }
}
