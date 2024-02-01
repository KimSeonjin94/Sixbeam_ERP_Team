package com.erpproject.sixbeam.hr.dto;

import com.erpproject.sixbeam.hr.entity.DepartEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartDto {
    private Long departCd;//부서코드
    private String departNm;//부서이름
    public DepartEntity toEntity(){
      return new DepartEntity(departCd,departNm);
    };
}
