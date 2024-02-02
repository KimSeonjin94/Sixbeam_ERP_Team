package com.erpproject.sixbeam.hr.dto;

import com.erpproject.sixbeam.hr.entity.PositionEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReasonDto {
    private Long reasonCd;//사유코드;
    private String reasonNm;//사유명;
    public PositionEntity toEntity(){
        return new PositionEntity(reasonCd,reasonNm);
    }
}
