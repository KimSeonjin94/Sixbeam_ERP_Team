package com.erpproject.sixbeam.ac.entity;

import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="AC_SALES_TB")
public class SalesEntity {

    @Column(name="SALES_NB",nullable = false)
    private String salesNb;
    @ManyToOne
    @JoinColumn(name="ACCOUNT_CD")
    private AccountEntity accountEntity;
    @Id
    @Column(name="SALE_CD")
    private String saleCd;
    @Column(name="SALES_PRICE")
    private long salesPrice;
    @Column(name="SALES_SUBJECT",nullable = false)
    private String salesSubject;

    @ManyToOne
    @JoinColumn(name = "SALE_CD", referencedColumnName = "SALE_CD", insertable = false, updatable = false)
    private SaleEntity saleEntity;

}
