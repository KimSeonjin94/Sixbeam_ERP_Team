package com.erpproject.sixbeam.ss.dto;


import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;

import lombok.Getter;

import lombok.Setter;


@Getter
@Setter
public class SaleAndEstimateDto {
    private SaleEntity saleEntity;
    private EstimateEntity estimateEntity;
}
