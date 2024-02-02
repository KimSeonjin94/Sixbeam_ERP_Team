package com.erpproject.sixbeam.hr.dto;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.entity.SalaryEntity;
import com.erpproject.sixbeam.hr.entity.SalaryIdEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaryDto {
    private Long empInfoId;
    private EmpInfoEntity empInfoEntity;//사원아이디
    private int salarySmonth;//급여 월
    private SalaryIdEntity salaryidEntity;//급여식별자
    private int salaryBouns;//상여금
    private int salaryAllow;//수당금
    private int salaryIncentive;//성과금
    private int salaryTtmoney;//총지급액
    public SalaryEntity toEntity(){
        return new SalaryEntity(empInfoId,empInfoEntity,salarySmonth,salaryidEntity,
                salaryBouns,salaryAllow,salaryIncentive,salaryTtmoney);
    }
}
