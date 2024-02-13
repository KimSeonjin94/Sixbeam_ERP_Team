package com.erpproject.sixbeam.hr.service;

import com.erpproject.sixbeam.hr.entity.DepartEntity;
import com.erpproject.sixbeam.hr.entity.PositionEntity;
import com.erpproject.sixbeam.hr.entity.SalaryIdEntity;
import com.erpproject.sixbeam.hr.repository.SalaryIdRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryIdService {
    private final SalaryIdRepository salaryIdRepository;
    public List<SalaryIdEntity> getList() {
        return this.salaryIdRepository.findAll();
    }
    public void updateSalaryId(Long salaryIdCd, DepartEntity departCd, PositionEntity positionCd, int basicSalary){
        SalaryIdEntity salaryIdEntity = salaryIdRepository.findById(salaryIdCd)
                .orElseThrow(() -> new RuntimeException("Depart with ID "+ salaryIdCd + " not fount"));
        salaryIdEntity.setSalaryIdCd(salaryIdCd);
        salaryIdEntity.setDepartEntity(departCd);
        salaryIdEntity.setPositionEntity(positionCd);
        salaryIdEntity.setBasicSalary(basicSalary);
        salaryIdRepository.save(salaryIdEntity);

    }
    public void createSalaryId(DepartEntity departCd, PositionEntity positionCd, int basicSalary){
        SalaryIdEntity salaryIdEntity = new SalaryIdEntity();
        salaryIdEntity.setDepartEntity(departCd);
        salaryIdEntity.setPositionEntity(positionCd);
        salaryIdEntity.setBasicSalary(basicSalary);
        salaryIdRepository.save(salaryIdEntity);
    }
    public void deleteSalaryId(Long salaryIdCd){
        this.salaryIdRepository.deleteById(salaryIdCd);
    }
}

