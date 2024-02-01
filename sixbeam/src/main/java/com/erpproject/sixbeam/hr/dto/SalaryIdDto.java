package com.erpproject.sixbeam.hr.dto;

import com.erpproject.sixbeam.hr.controller.DepartController;
import com.erpproject.sixbeam.hr.entity.DepartEntity;
import com.erpproject.sixbeam.hr.entity.PositionEntity;
import com.erpproject.sixbeam.hr.entity.SalaryIdEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaryIdDto {
    private Long salaryCd;//급여식별자
    private DepartEntity departEntity;//부서코드
    private PositionEntity positionEntity;//직책코드
    private int basicSalary;//기본급여
    public SalaryIdEntity toEntity(){
        return new SalaryIdEntity(salaryCd,departEntity,positionEntity,basicSalary);
    }
}
