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
@Table(name="SS_SALE_TB")
public class SaleEntity {

    @Id
    @Column(name = "SALE_CD")
    private String saleCd;
    @Column(name = "ESTIMATE_CD")
    private String estimateCd;
    @Column(name = "SALE_UPLOAD_DT")
    private LocalDate saleUploadDt;
    @Column(name = "SALE_BILLING_DT")
    private LocalDate saleBillingDt;
    @Column(name = "SALE_BILLING_ST", columnDefinition = "TINYINT(1)")
    private boolean saleBillingSt;
    @Column(name = "SALE_PAYMENT_DT")
    private LocalDate salePaymentDt;
    @ManyToOne
    @JoinColumn(name = "whregist_cd")
    private WhregistEntity whregistEntity;
    @Column(name = "SALE_SHIPPING_ST")
    private String saleShippingSt;
    @Column(name = "SALE_SHIPPING_DT")
    private LocalDate saleShippingDt;

}
