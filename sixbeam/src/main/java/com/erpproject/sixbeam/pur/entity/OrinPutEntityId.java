package com.erpproject.sixbeam.pur.entity;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class OrinPutEntityId implements Serializable {
    private String poCd;
    private ItemEntity itemEntity;
}
