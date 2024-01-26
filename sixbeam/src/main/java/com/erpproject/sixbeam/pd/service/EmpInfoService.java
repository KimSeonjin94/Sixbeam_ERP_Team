package com.erpproject.sixbeam.pd.service;

import com.erpproject.sixbeam.pd.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.repository.EmpInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpInfoService {
    private final EmpInfoRepository empInfoRepository;

    public List<EmpInfoEntity> getList(){
        return this.empInfoRepository.findAll();
    }
}
