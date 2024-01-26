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
@Table(name = "ST_RELEASE_TB")
public class ReleaseEntity {

    @Column(name = "RELEASE_DT")
    private LocalDate releaseDt;

    @Id
    @Column(name = "RELEASE_CD")
    private String releaseCd;

    @Column(name = "ACCOUNT_CD")
    private String accountCd;

    @Column(name = "EI_ID")
    private String eiId;

    @Column(name = "WH_MOVE_CD")
    private String whMoveCd;

    @Column(name = "RELEASE_RV")
    private String releaseRv;

    @Column(name = "RELEASE_PHONE")
    private String releasePhone;

    @Column(name = "RELEASE_ZC")
    private String releaseZc;

    @Column(name = "RELEASE_ADDR")
    private String releaseAddr;
}
