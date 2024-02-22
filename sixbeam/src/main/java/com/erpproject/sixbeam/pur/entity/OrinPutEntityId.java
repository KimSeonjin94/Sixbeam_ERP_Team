package com.erpproject.sixbeam.pur.entity;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrinPutEntityId implements Serializable {
    private String orinputCd;
    private String itemCd;
}
