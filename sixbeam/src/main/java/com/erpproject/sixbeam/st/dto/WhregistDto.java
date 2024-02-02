package com.erpproject.sixbeam.st.dto;

import com.erpproject.sixbeam.st.entity.WhregistEntity;

public class WhregistDto {

    private String whregistCd;

    private String whregistNm;

    public WhregistEntity toEntity() {
        return new WhregistEntity(whregistCd,whregistNm);
    }


}
