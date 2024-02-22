package com.erpproject.sixbeam.st.entity;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@IdClass(ReleaseEntityId.class)
@Table(name = "st_release_tb")
public class ReleaseEntity {

    @Column(name = "release_dt")
    private LocalDate releaseDt;

    @Id
    @Column(name = "release_cd")
    private String releaseCd;

    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_CD")
    private ItemEntity itemEntity;

    @ManyToOne
    @JoinColumn(name = "account_cd")
    private AccountEntity accountEntity;

    @ManyToOne
    @JoinColumn(name = "empinfo_id")
    private EmpInfoEntity empInfoEntity;

    @ManyToOne
    @JoinColumn(name = "sale_cd")
    private SaleEntity saleEntity;

    @ManyToOne
    @JoinColumn(name = "whregist_cd")
    private WhregistEntity whregistEntity;

    @Column(name = "release_rv")
    private String releaseRv;

    @Column(name = "release_amt")
    private Integer releaseAmt;

    @Column(name = "release_phone")
    private String releasePhone;

    @Column(name = "release_zc")
    private String releaseZc;

    @Column(name = "release_addr")
    private String releaseAddr;
}
