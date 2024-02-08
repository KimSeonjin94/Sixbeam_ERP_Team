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
    @JoinColumn(name="check_cd")
    private CheckEntity checkEntity;

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

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESTIMATE_sequence_generator")
    @SequenceGenerator(name = "ESTIMATE_sequence_generator", sequenceName = "ESTIMATE_sequence_generator",initialValue = 101, allocationSize = 1)
    private Long number;


    @PrePersist
    protected void onCreate() {
        // 현재 날짜를 "SSYYMMDD" 형식으로 가져오기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        String formattedDate = estimateDt.format(formatter);

        // 여기서는 고정적으로 "1001"을 추가했지만, 실제 시퀀스를 사용하거나 다른 로직을 사용할 수 있습니다.
        this.estimateCd="ES" + formattedDate+number;

        //출고가 부가세  총액 계산하기
        this.estimateSp=estimateAmt*estimateUp;
        this.estimateVat=estimateSp /10;
        this.estimateTamt=estimateSp+estimateVat;
    }




}
