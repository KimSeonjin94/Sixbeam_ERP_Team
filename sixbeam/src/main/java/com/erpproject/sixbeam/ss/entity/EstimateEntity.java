package com.erpproject.sixbeam.ss.entity;

import com.erpproject.sixbeam.hr.dto.EmpInfoDto;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
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
@Table(name="SS_ESIMATE_TB")
public class EstimateEntity {
    @Id
    @Column(name = "ESTIMATE_CD")
    @OneToMany
    private String estimateCd;
    @Column(name = "ESTIMATE_DT")
    private LocalDate estimateDt;
    @Column(name = "CHECK_AMT")
    private int checkAmt;

    @ManyToOne
    @JoinColumn(name="EI_ID")
    private EmpInfoEntity empInfoEntity;

    @ManyToOne
    @JoinColumn(name="ACCOUNT_CD")
    private AccountEntity accountEntity;

    @Column(name = "ESTIMATE_NM")
    private String estimateNm;

    @ManyToOne
    @JoinColumn(name="BOM_ITEM_CD")
    private ItemEntity itemEntity;

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

    @OneToMany(mappedBy = "SaleEntity", cascade = CascadeType.ALL) // EstimateEntity 클래스의 memberEntity 필드에 매핑됨
    private List<SaleEntity> saleEntities;
    @OneToMany(mappedBy = "MemberEntity", cascade = CascadeType.ALL)
    private List<MemberEntity> memberEntities;



}
