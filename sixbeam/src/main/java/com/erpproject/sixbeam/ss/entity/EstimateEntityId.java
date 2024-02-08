package com.erpproject.sixbeam.ss.entity;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class EstimateEntityId implements Serializable {
    private String estimateCd;
    private ItemEntity itemEntity;
}
