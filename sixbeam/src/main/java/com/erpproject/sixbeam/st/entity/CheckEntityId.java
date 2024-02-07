package com.erpproject.sixbeam.st.entity;

import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
public class CheckEntityId implements Serializable {
    private WhmoveEntity whmoveEntity;
    private ItemEntity itemEntity;

}
