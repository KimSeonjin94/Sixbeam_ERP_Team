package com.erpproject.sixbeam.pur.dto;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class OrinPutDto {
    private String orinputCd;
    private LocalDate orinputReqDt;
    private LocalDate orinputOrDt;
    private EmpInfoEntity empInfoEntity;
    private ItemEntity itemEntity;
    private int orinputAmt;
    private int orinputUp;
    private int orinputSp;
    private int orinputVat;
    private int orinputSum;
    private AccountEntity accountEntity;
    private LocalDate orinputDlvyDt;
    private String orinputEtc;

    public OrinPutEntity toEntity() {
        OrinPutEntity entity = new OrinPutEntity();

        // Entity에 값을 설정하는 부분
        entity.setOrinputCd(this.orinputCd);
        entity.setOrinputReqDt(this.orinputReqDt);
        entity.setOrinputOrDt(this.orinputOrDt);
        entity.setEmpInfoEntity(this.empInfoEntity);
        entity.setItemEntity(this.itemEntity);
        entity.setOrinputAmt(this.orinputAmt);
        entity.setOrinputUp(this.orinputUp);
        entity.setOrinputSp(this.orinputSp);
        entity.setOrinputVat(this.orinputVat);
        entity.setOrinputSum(this.orinputSum);
        entity.setAccountEntity(this.accountEntity);
        entity.setOrinputDlvyDt(this.orinputDlvyDt);
        entity.setOrinputEtc(this.orinputEtc);

        return entity;
    }
}
