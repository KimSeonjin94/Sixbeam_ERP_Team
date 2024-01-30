package com.erpproject.sixbeam.ss.entity;


import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.ss.dto.AccountEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@IdClass(EstimateEntityId.class)
@Table(name="SS_ESIMATE_TB")
public class EstimateEntity {
    @Id
    @Column(name = "ESTIMATE_CD")
    private String estimateCd;

    @Column(name = "ESTIMATE_DT")
    private LocalDate estimateDt;

    @Id
    @Column(name = "ITEM_CD")
    private String itemCd;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "CHECK_DT", referencedColumnName = "CHECK_DT"),
            @JoinColumn(name = "ITEM_CD", referencedColumnName = "ITEM_CD")
    })
    private CheckEntity checkEntity;

    @ManyToOne
    @JoinColumn(name="EI_ID")
    private EmpInfoEntity empInfoEntity;

    @ManyToOne
    @JoinColumn(name="ACCOUNT_CD")
    private AccountEntity accountEntity;

    @Column(name = "ESTIMATE_NM")
    private String estimateNm;

    @Column(name = "ESTIMATE_AMT")
    private int estimateAmt;

    @Column(name = "ESTIMATE_UP")
    private int estimateUp;

    @Column(name = "ESTIMATE_SP")
    private int estimateSp;

    @Column(name = "ESTIMATE_VAT")
    private int estimateVat;

    @Column(name = "ESTIMATE_TAMT")
    private int estimateTamt;

    @Column(name = "ESTIMATE_ETC")
    private String estimateEtc;




}
