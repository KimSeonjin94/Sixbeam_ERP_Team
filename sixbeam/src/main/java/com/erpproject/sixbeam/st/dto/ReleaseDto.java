package com.erpproject.sixbeam.st.dto;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.st.entity.ReleaseEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReleaseDto {

    private LocalDate releaseDt;

    private String releaseCd;

    private EmpInfoEntity empInfoEntity;

    private SaleEntity saleEntity;

    private String releaseRv;

    private String releasePhone;

     private String releaseAddr;

    public ReleaseEntity toEntity() {
        ReleaseEntity entity = new ReleaseEntity();
        entity.setReleaseDt(this.releaseDt);
        entity.setReleaseCd(this.releaseCd);
        entity.setEmpInfoEntity(this.empInfoEntity);
        entity.setSaleEntity(this.saleEntity);
        entity.setReleaseRv(this.releaseRv);
        entity.setReleasePhone(this.releasePhone);
        entity.setReleaseAddr(this.releaseAddr);
        return entity;
    }

}
