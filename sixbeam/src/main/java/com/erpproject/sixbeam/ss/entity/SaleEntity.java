package com.erpproject.sixbeam.ss.entity;

import com.erpproject.sixbeam.st.entity.ReleaseEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
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
@Table(name="ss_sale_tb")
public class SaleEntity {

    @Id
    @Column(name = "sale_cd")
    private String saleCd;
    @Column(name = "estimate_cd")
    private String estimateCd;
    @Column(name = "sale_upload_dt")
    private LocalDate saleUploadDt;
    @Column(name = "sale_billing_dt")
    private LocalDate saleBillingDt;
    @Column(name = "sale_billing_st", columnDefinition = "tinyint(1)")
    private boolean saleBillingSt;
    @Column(name = "sale_payment_dt")
    private LocalDate salePaymentDt;
    @ManyToOne
    @JoinColumn(name = "whregist_cd")
    private WhregistEntity whregistEntity;
    @Column(name = "sale_shipping_st")
    private String saleShippingSt;
    @Column(name = "sale_shipping_dt")
    private LocalDate saleShippingDt;

}
