package com.erpproject.sixbeam.st.dto;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;

import java.time.LocalDate;

public class AsDto {

    private LocalDate asDt;

    private String asCd;

    private EmpInfoEntity empInfoEntity;

    private AccountEntity accountEntity;

    private WhmoveEntity whmoveEntity;

    private String asSt;

    private LocalDate asCmptDt;

    private String asTi;

    private String asMo;

    public AsEntity toEntity() {
        return new AsEntity(asDt, asCd, empInfoEntity, accountEntity, whmoveEntity, asSt, asCmptDt, asTi, asMo);
    }

}
