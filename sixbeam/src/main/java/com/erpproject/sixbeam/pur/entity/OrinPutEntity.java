package com.erpproject.sixbeam.pur.entity;


import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "PUR_ORINPUT_TB")
public class OrinPutEntity {
    @Id
    @Column(name = "ORINPUT_CD")
    private String orinputCd;
    @Column(name = "ORINPUTREQ_DT", nullable = false)
    private LocalDate orinputReqDt;
    @Column(name = "ORINPUTOR_DT", nullable = false)
    private LocalDate orinputOrDt;
    @ManyToOne
    @JoinColumn(name = "EMPINFO_ID", nullable = false)
    private EmpInfoEntity empInfoEntity;
    @ManyToOne
    @JoinColumn(name = "ITEM_CD", nullable = false)
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
    @ManyToOne
    @JoinColumn(name = "ACCOUNT_CD", nullable = false)
    private AccountEntity accountEntity;
    @Column(name = "ORINPUTDLVY_DT")
    private LocalDate orinputDlvyDt;
    @Column(name = "ORINPUT_ETC")
    private String orinputEtc;

}
