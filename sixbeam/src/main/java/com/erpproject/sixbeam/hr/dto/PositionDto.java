package com.erpproject.sixbeam.hr.dto;

import com.erpproject.sixbeam.hr.entity.PositionEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionDto {
    private Long positionCd;//직책코드
    private String positionNm;//직책명
    public PositionEntity toEntity(){
        return new PositionEntity(positionCd,positionNm);
    }
}
