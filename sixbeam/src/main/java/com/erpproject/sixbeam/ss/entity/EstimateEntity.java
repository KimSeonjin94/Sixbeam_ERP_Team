package com.erpproject.sixbeam.ss.entity;


import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="SS_ESIMATE_TB")
public class EstimateEntity {
    @Id
    @Column(name = "ESTIMATE_CD")
    private String estimateCd;
    @Column(name = "ESTIMATE_DT")
    private LocalDate estimateDt;

    @JoinColumns({
            @JoinColumn(name = "CHECK_DT", referencedColumnName = "checkDt"),
            @JoinColumn(name = "ITEM_CD", referencedColumnName = "itemCd")
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

    @OneToMany(mappedBy = "estimateEntity", cascade = CascadeType.ALL)
    private List<SaleEntity> saleEntities;
    @OneToMany(mappedBy = "estimateEntity", cascade = CascadeType.ALL)
    private List<MemberEntity> memberEntities;

    public EstimateEntity(String estimateCd, LocalDate estimateDt, CheckEntity checkEntity,
                      EmpInfoEntity empInfoEntity, AccountEntity accountEntity,
                      String estimateNm, int estimateAmt,
                      int estimateUp, int estimateSp, int estimateVat,
                      int estimateTamt, String estimateEtc) {
        this.estimateCd = estimateCd;
        this.estimateDt = estimateDt;
        this.checkEntity = checkEntity;
        this.empInfoEntity = empInfoEntity;
        this.accountEntity = accountEntity;
        this.estimateNm = estimateNm;
        this.estimateAmt = estimateAmt;
        this.estimateUp = estimateUp;
        this.estimateSp = estimateSp;
        this.estimateVat = estimateVat;
        this.estimateTamt = estimateTamt;
        this.estimateEtc = estimateEtc;
    }

}
