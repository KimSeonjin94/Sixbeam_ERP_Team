package com.erpproject.sixbeam.ss.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class EstimateEntityId implements Serializable {
    private String estimateCd;
    private String itemCd;
}
