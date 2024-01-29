package com.erpproject.sixbeam.pur.entity;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@Entity
@Table(name="PUR_ORINPUT_TB")
public class OrinPutEntity {
    @Id
    @Column(name = "PO_CD")
    private String poCd;
    @NotNull
    @Column(name = "PUR_REQ_DT")
    private LocalDate purReqDt;
    @Column(name = "ORDER_DT")
    private LocalDate orderDt;
    @ManyToOne
    @NotNull
    @Column(name = "EI_ID")
    private EmpInfoEntity empInfoEntity;
    @NotNull
    @Column(name = "ITEM_CD")
    private ItemEntity itemEntity;
    @Column(name = "ORINPUT_AMT")
    private int orinputAmt;
    @Column(name = "ORINPUT_UP")
    private int orinputUp;
    @Column(name = "ORINPUT_SP")
    private int orinputSp;
    @Column(name = "ORINPUT_VAT")
    private int orinputVat;
    @Column(name = "ORINPUT_SUM")
    private int orinputSum;
    @NotNull
    @Column(name = "ACCOUNT_CD")
    private AccountEntity accountEntity;
    @Column(name = "DELIVERY_DT")
    private LocalDate deliveryDt;
    @Column(name = "ORINPUT_ETC")
    private String orinputEtc;
}
