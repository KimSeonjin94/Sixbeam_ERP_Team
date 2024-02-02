package com.erpproject.sixbeam.pd.entity;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PD_ORDER_TB")
public class OrderEntity {

    @Id
    @Column(name = "ORDER_CD")
    private String orderCd;

    @Column(name = "ORDER_INST_DT")
    private Date orderInstDt;

    @Column(name = "ORDER_DELIV_DT")
    private Date orderDelivDt;

    @ManyToOne
    @JoinColumn(name = "EI_ID")
    private EmpInfoEntity empInfoEntity;

    @ManyToOne
    @JoinColumn(name = "ITEM_CD")
    private ItemEntity itemEntity;

    @Column(name = "ORDER_AMT")
    private int orderAmt;

    @Column(name = "ORDER_ST")
    private boolean orderSt;
}
