package com.erpproject.sixbeam.st.entity;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class ReleaseEntityId implements Serializable {
    private String releaseCd;
    private ItemEntity itemEntity;
}
