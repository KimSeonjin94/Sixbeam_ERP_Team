package com.erpproject.sixbeam.pd.entity;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pd_order_tb")
public class OrderEntity {

    @Id
    @Column(name = "order_cd", nullable = false)
    private String orderCd;

    @Column(name = "order_inst_dt")
    private LocalDate orderInstDt;

    @Column(name = "order_deliv_dt")
    private LocalDate orderDelivDt;

    @ManyToOne
    @JoinColumn(name = "empinfoId", nullable = false)
    private EmpInfoEntity empInfoEntity;

    @ManyToOne
    @JoinColumn(name = "item_cd", nullable = false)
    private ItemEntity itemEntity;

    @Column(name = "order_amt")
    private int orderAmt;

    @Column(name = "order_st")
    private boolean orderSt;
}
