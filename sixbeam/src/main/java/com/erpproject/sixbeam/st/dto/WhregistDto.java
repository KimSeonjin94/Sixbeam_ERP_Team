package com.erpproject.sixbeam.st.dto;

import com.erpproject.sixbeam.st.entity.WhregistEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class WhregistDto {

    private String whregistCd;

    private String whregistNm;

    public WhregistEntity toEntity() {
        WhregistEntity entity = new WhregistEntity();
        entity.setWhregistCd(this.whregistCd);
        entity.setWhregistNm(this.whregistNm);
        return entity;
    }
}
