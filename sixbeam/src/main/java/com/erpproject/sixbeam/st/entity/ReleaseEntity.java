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
@Table(name = "st_release_tb")
public class ReleaseEntity {

    @Column(name = "release_dt")
    private LocalDate releaseDt;

    @Id
    @Column(name = "release_cd")
    private String releaseCd;

    @ManyToOne
    @JoinColumn(name = "account_cd")
    private AccountEntity accountEntity;

    @ManyToOne
    @JoinColumn(name = "ei_id")
    private EmpInfoEntity empInfoEntity;

    @ManyToOne
    @JoinColumn(name = "whmove_cd")
    private WhmoveEntity whmoveEntity;

    @Column(name = "release_rv")
    private String releaseRv;

    @Column(name = "release_phone")
    private String releasePhone;

    @Column(name = "release_zc")
    private String releaseZc;

    @Column(name = "release_addr")
    private String releaseAddr;
}
