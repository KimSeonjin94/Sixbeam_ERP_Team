package com.erpproject.sixbeam.st.dto;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.st.entity.ReleaseEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;

import java.time.LocalDate;

public class ReleaseDto {

    private LocalDate releaseDt;

    private String releaseCd;

    private AccountEntity accountEntity;

    private EmpInfoEntity empInfoEntity;

    private WhmoveEntity whmoveEntity;

    private String releaseRv;

    private String releasePhone;

    private String releaseZc;

    private String releaseAddr;

    public ReleaseEntity toEntity() {
        return new ReleaseEntity(releaseDt,releaseCd,accountEntity,empInfoEntity,whmoveEntity,releaseRv,releasePhone,releaseZc,releaseAddr);
    }

}
