package com.erpproject.sixbeam.st.dto;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AsDto {

    private LocalDate asDt;

    private String asCd;

    private EmpInfoEntity empInfoEntity;

    private AccountEntity accountEntity;

    private ItemEntity itemEntity;

    private WhregistEntity whregistEntity;

    private Integer asAmt;

    private String asSt;

    private LocalDate ascmptDt;

    private String asTi;

    private String asMo;

    public AsEntity toEntity() {
        AsEntity entity = new AsEntity();
        entity.setAsDt(this.asDt);
        entity.setAsCd(this.asCd);
        entity.setEmpInfoEntity(this.empInfoEntity);
        entity.setAccountEntity(this.accountEntity);
        entity.setItemEntity(this.itemEntity);
        entity.setWhregistEntity(this.whregistEntity);
        entity.setAsAmt(this.asAmt);
        entity.setAsSt(this.asSt);
        entity.setAscmptDt(this.ascmptDt);
        entity.setAsTi(this.asTi);
        entity.setAsMo(this.asMo);
        return entity;
    }
}
