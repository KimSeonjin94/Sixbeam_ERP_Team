package com.erpproject.sixbeam.hr.service;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.entity.SalaryEntity;
import com.erpproject.sixbeam.hr.entity.SalaryIdEntity;
import com.erpproject.sixbeam.hr.repository.SalaryRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryService {
    private final SalaryRepository salaryRepository;
    public List<SalaryEntity> getList() {
        return this.salaryRepository.findAll();
    }
    public void createSalary(YearMonth salarySmonth, SalaryIdEntity salaryIdCd, EmpInfoEntity empInfoId,
                             int salaryBonus, int salaryAllow,int salaryIncentive, Integer salaryTtmoney){
        SalaryEntity salaryEntity = new SalaryEntity();
        salaryEntity.setSalarySmonth(salarySmonth);
        salaryEntity.setSalaryIdEntity(salaryIdCd);
        salaryEntity.setEmpInfoEntity(empInfoId);
        salaryEntity.setSalaryBonus(salaryBonus);
        salaryEntity.setSalaryAllow(salaryAllow);
        salaryEntity.setSalaryIncentive(salaryIncentive);
        salaryEntity.setSalaryTtmoney(salaryTtmoney);
        salaryRepository.save(salaryEntity);
    }
    public void deleteSalary(Long salaryCd){this.salaryRepository.deleteById(salaryCd);}
    public void updateSalary(Long salaryCd,YearMonth salarySmonth, SalaryIdEntity salaryIdCd, EmpInfoEntity empInfoId,
                             int salaryBonus, int salaryAllow,int salaryIncentive, Integer salaryTtmoney){
        SalaryEntity salaryEntity = salaryRepository.findById(salaryCd)
                .orElseThrow(() -> new RuntimeException("Depart with ID "+ salaryCd + " not fount"));
        salaryEntity.setSalaryCd(salaryCd);
        salaryEntity.setSalarySmonth(salarySmonth);
        salaryEntity.setSalaryIdEntity(salaryIdCd);
        salaryEntity.setEmpInfoEntity(empInfoId);
        salaryEntity.setSalaryBonus(salaryBonus);
        salaryEntity.setSalaryAllow(salaryAllow);
        salaryEntity.setSalaryIncentive(salaryIncentive);
        salaryEntity.setSalaryTtmoney(salaryTtmoney);
        salaryRepository.save(salaryEntity);
    }
}
