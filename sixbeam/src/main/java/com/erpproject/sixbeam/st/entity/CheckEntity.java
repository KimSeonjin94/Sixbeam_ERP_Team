package com.erpproject.sixbeam.st.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "ST_CHECK_TB")
public class CheckEntity {
    @Id
    @Column(name = "CHECK_DT")
    private LocalDate checkDt;

    @Id
    @Column(name = "ITEM_CD")
    private String itemCd;

    @Column(name = "CHECK_UP")
    private Integer checkUp;

    @Column(name = "CHECK_PR")
    private Integer checkPr;

    @Column(name = "CHECK_AMT")
    private Integer checkAmt;
}
