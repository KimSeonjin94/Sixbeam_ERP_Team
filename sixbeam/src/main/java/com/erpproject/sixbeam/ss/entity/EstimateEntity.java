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
@Table(name="SS_ESTIMATE_TB")
public class EstimateEntity {
    @Id
    @Column(name = "ESTIMATE_CD")
    private String estimateCd;
    @Column(name = "ESTIMATE_DT")
    private LocalDate estimateDt;
    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_CD")
    private ItemEntity itemEntity;
    @ManyToOne
    @JoinColumn(name="empinfoId")
    private EmpInfoEntity empInfoEntity;
    @ManyToOne
    @JoinColumn(name="ACCOUNT_CD")
    private AccountEntity accountEntity;
    @Column(name = "ESTIMATE_NM")
    private String estimateNm;
    @Column(name = "ESTIMATE_AMT")
    private Integer estimateAmt;
    @Column(name = "ESTIMATE_UP")
    private Integer estimateUp;
    @Column(name = "ESTIMATE_SP")
    private Integer estimateSp;
    @Column(name = "ESTIMATE_VAT")
    private Integer estimateVat;
    @Column(name = "ESTIMATE_TAMT")
    private Integer estimateTamt;
    @Column(name = "ESTIMATE_ETC")
    private String estimateEtc;
}
