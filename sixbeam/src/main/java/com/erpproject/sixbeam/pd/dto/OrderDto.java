package com.erpproject.sixbeam.pd.dto;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.OrderEntity;

import java.util.Date;

public class OrderDto {

    private String orderCd;
    private Date orderInstDt;
    private Date orderDelivDt;
    private EmpInfoEntity empInfoEntity;
    private ItemEntity itemEntity;
    private int orderAmt;
    private boolean orderSt;

    public OrderEntity toEntity() {
        return new OrderEntity(orderCd, orderInstDt, orderDelivDt, empInfoEntity, itemEntity, orderAmt, orderSt);
    }
}
