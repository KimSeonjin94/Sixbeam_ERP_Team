package com.erpproject.sixbeam.st.entity;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "st_whmove_tb")
public class WhmoveEntity {


    @Id
    @Column(name = "whmove_cd")
    private String whmoveCd;

    @ManyToOne
    @JoinColumn(name = "empinfo_id")
    private EmpInfoEntity empInfoEntity;

    @Column(name = "whmove_dt")
    private LocalDate whmoveDt;

    @ManyToOne
    @JoinColumn(name = "item_cd")
    private ItemEntity itemEntity;

    @ManyToOne
    @JoinColumn(name = "whregist_cd")
    private WhregistEntity whregistEntity;

    @Column(name = "as_cd")
    private String asCd;

    @Column(name = "SALE_CD")
    private String saleCd;

    @Column(name = "INOUT_CMPT_CD")
    private String inoutCmptCd;

    @Column(name = "INPUTPUR_CD")
    private String inputPurCd;

    @Column(name = "whmove_amt")
    private Integer whmoveAmt;

    @Column(name = "whmove_gb")
    private String whmoveGb;

}
