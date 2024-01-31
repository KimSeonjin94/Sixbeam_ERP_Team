package com.erpproject.sixbeam.pd.dto;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.InoutEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;

public class InoutDto {

    private String inoutCmptCd;
    private EmpInfoEntity empInfoEntity;
    private WhmoveEntity whmoveEntity;

    public InoutEntity toEntity() {
        return new InoutEntity(inoutCmptCd, empInfoEntity, whmoveEntity);
    }
}
