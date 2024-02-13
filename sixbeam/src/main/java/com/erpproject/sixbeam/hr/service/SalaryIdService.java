package com.erpproject.sixbeam.hr.service;

import com.erpproject.sixbeam.hr.entity.SalaryIdEntity;
import com.erpproject.sixbeam.hr.repository.SalaryIdRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SalaryIdService {
    private final SalaryIdRepository salaryIdRepository;
    public List<SalaryIdEntity>getList(){
        return this.salaryIdRepository.findAll();
    }
}
