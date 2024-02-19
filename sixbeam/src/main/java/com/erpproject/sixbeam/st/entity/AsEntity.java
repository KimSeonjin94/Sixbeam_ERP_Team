package com.erpproject.sixbeam.st.entity;

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
@Entity
@Getter
@Setter
@Table(name = "st_as_tb")
public class AsEntity {

    @Column(name = "as_dt")
    private LocalDate asDt;

    @Id
    @Column(name = "as_cd")
    private String asCd;

    @ManyToOne
    @JoinColumn(name = "empinfoId")
    private EmpInfoEntity empInfoEntity;

    @ManyToOne
    @JoinColumn(name = "account_cd")
    private AccountEntity accountEntity;

    @ManyToOne
    @JoinColumn(name = "ITEM_CD")
    private ItemEntity itemEntity;

    @ManyToOne
    @JoinColumn(name = "whregist_cd")
    private WhregistEntity whregistEntity;

    @Column(name = "as_amt")
    private Integer asAmt;

    @Column(name = "as_st")
    private String asSt;

    @Column(name = "ascmpt_dt")
    private LocalDate ascmptDt;

    @Column(name = "as_ti")
    private String asTi;

    @Column(name = "as_mo")
    private String asMo;

}

