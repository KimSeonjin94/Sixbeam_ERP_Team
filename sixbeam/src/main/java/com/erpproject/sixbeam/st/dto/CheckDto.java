package com.erpproject.sixbeam.st.dto;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.st.entity.CheckEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;

import java.time.LocalDate;

public class CheckDto {
    private LocalDate checkDt;

    private ItemEntity itemEntity;

    private WhmoveEntity whmoveEntity;

    private Integer checkUp;

    private Integer checkPr;

    private Integer checkAmt;

    public CheckEntity toEntity() {
        CheckEntity checkEntity = new CheckEntity(checkDt,whmoveEntity,itemEntity,checkUp,checkPr,checkAmt);
        checkEntity.setCheckDt(checkDt);
        checkEntity.setWhmoveEntity(whmoveEntity);
        checkEntity.setItemEntity(itemEntity);
        checkEntity.setCheckUp(checkUp);
        checkEntity.setCheckPr(checkPr);
        checkEntity.setCheckAmt(checkAmt);
        return checkEntity;
    }


}
