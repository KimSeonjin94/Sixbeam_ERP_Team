package com.erpproject.sixbeam.st.dto;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.entity.CheckEntity;

import java.time.LocalDate;

public class CheckDto {
    private LocalDate checkDt;

    private ItemEntity itemEntity;

    private Integer checkUp;

    private Integer checkPr;

    private Integer checkAmt;

    public CheckEntity toEntity() {
        return new CheckEntity(checkDt,itemEntity,checkUp,checkPr,checkAmt);
    }


}
