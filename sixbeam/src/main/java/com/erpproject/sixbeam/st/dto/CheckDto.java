package com.erpproject.sixbeam.st.dto;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.st.entity.CheckEntity;
import com.erpproject.sixbeam.st.entity.ReleaseEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class CheckDto {

    private Long checkCd;

    private Integer checkAmt;

    private WhmoveEntity whmoveEntity;

    public CheckEntity toEntity() {
        return new CheckEntity(checkCd,checkAmt,whmoveEntity);
    }
}