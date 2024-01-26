package com.erpproject.sixbeam.hr.service;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
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
