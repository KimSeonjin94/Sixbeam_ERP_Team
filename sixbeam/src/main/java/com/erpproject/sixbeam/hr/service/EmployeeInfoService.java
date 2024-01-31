package com.erpproject.sixbeam.hr.service;

import com.erpproject.sixbeam.hr.entity.EmployeeInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmployeeInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeInfoService {
    private final EmployeeInfoRepository employeeInfoRepository;

    public List<EmployeeInfoEntity> getList(){
        return this.employeeInfoRepository.findAll();
    }
}
