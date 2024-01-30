package com.erpproject.sixbeam.st.entity;

import com.erpproject.sixbeam.hr.entity.EmployeeInfoEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "st_whmove_tb")
public class WhmoveEntity {

    @Id
    @Column(name = "whmove_cd")
    private String whmoveCd;

    @ManyToOne
    @JoinColumn(name = "ei_id")
    private EmployeeInfoEntity employeeInfoEntity;

    @Column(name = "whmove_dt")
    private LocalDate whmoveDt;

    @ManyToOne
    @JoinColumn(name = "item_cd")
    private ItemEntity itemEntity;

    @ManyToOne
    @JoinColumn(name = "whregist_cd")
    private WhregistEntity whregistEntity;

    @Column(name = "whmove_amt")
    private Integer whmoveAmt;

    @Column(name = "whmove_gb")
    private String whmoveGb;

}
