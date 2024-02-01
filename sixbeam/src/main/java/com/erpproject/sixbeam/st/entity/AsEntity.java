package com.erpproject.sixbeam.st.entity;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

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

    @JoinColumn(name = "empInfoId")
    private EmpInfoEntity empInfoEntity;


    @ManyToOne
    @JoinColumn(name = "account_cd")
    private AccountEntity accountEntity;

    @ManyToOne
    @JoinColumn(name = "whmove_cd")
    private WhmoveEntity whmoveEntity;


    @Column(name = "as_st")
    private String asSt;

    @Column(name = "ascmpt_dt")
    private LocalDate asCmptDt;

    @Column(name = "as_ti")
    private String asTi;

    @Column(name = "as_mo")
    private String asMo;

}

