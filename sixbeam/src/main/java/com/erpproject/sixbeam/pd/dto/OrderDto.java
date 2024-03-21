package com.erpproject.sixbeam.pd.dto;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.OrderEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
public class
OrderDto {

    private String orderCd;
    private LocalDate orderInstDt;
    private LocalDate orderDelivDt;
    private EmpInfoEntity empInfoEntity;
    private ItemEntity itemEntity;
    private int orderAmt;
    private boolean orderSt;

    public OrderEntity toEntity() {
        return new OrderEntity(orderCd, orderInstDt, orderDelivDt, empInfoEntity, itemEntity, orderAmt, orderSt);
    }
}
