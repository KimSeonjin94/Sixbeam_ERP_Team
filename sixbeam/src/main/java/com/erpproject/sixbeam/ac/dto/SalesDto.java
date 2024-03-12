package com.erpproject.sixbeam.ac.dto;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.entity.SalesEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SalesDto {
    private String salesNb;
    private AccountEntity accountEntity;
    private SaleEntity saleEntity;
    private int salesPrice;
    private String salesSubject;

    public SalesEntity toEntity() {

        return new SalesEntity(salesNb, accountEntity, saleEntity.getSaleCd(), salesPrice, salesSubject,saleEntity);
    }
}
