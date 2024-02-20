package com.erpproject.sixbeam.pur.entity;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class OrinPutEntityId implements Serializable {
    private String orinputCd;
    private ItemEntity itemEntity;
}
