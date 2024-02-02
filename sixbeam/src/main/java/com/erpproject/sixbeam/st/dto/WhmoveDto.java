package com.erpproject.sixbeam.st.dto;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;

import java.time.LocalDate;

public class WhmoveDto {

    private String whmoveCd;

    private EmpInfoEntity empInfoEntity;

    private LocalDate whmoveDt;

    private ItemEntity itemEntity;

    private WhregistEntity whregistEntity;

    private Integer whmoveAmt;

    private String whmoveGb;

    public WhmoveEntity toEntity() {
        return new WhmoveEntity(whmoveCd,empInfoEntity,whmoveDt,itemEntity,whregistEntity,whmoveAmt,whmoveGb);
    }

}
