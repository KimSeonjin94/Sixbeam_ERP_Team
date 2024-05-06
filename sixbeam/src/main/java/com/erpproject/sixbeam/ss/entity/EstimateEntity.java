package com.erpproject.sixbeam.ss.entity;


import com.erpproject.sixbeam.ac.entity.AccountEntity;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.st.entity.CheckEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@NoArgsConstructor
@Getter
@Setter
@Entity
@IdClass(EstimateEntityId.class)
@Table(name="ss_estimate_tb")
public class EstimateEntity {
    @Id
    @Column(name = "estimate_cd")
    private String estimateCd;
    @Column(name = "estimate_dt")
    private LocalDate estimateDt;
    @Id
    @ManyToOne
    @JoinColumn(name = "item_cd")
    private ItemEntity itemEntity;
    @ManyToOne
    @JoinColumn(name="empinfoId")
    private EmpInfoEntity empInfoEntity;
    @ManyToOne
    @JoinColumn(name="account_cd")
    private AccountEntity accountEntity;
    @Column(name = "estimate_nm")
    private String estimateNm;
    @Column(name = "estimate_amt")
    private Integer estimateAmt;
    @Column(name = "estimate_up")
    private Integer estimateUp;
    @Column(name = "estimate_sp")
    private Integer estimateSp;
    @Column(name = "estimate_vat")
    private Integer estimateVat;
    @Column(name = "estimate_tamt")
    private Integer estimateTamt;
    @Column(name = "estimate_etc")
    private String estimateEtc;
}
