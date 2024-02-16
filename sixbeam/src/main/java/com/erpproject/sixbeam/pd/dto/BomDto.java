package com.erpproject.sixbeam.pd.dto;

import com.erpproject.sixbeam.pd.entity.BomEntity;
import com.erpproject.sixbeam.pd.entity.FitemEntity;
import com.erpproject.sixbeam.pd.entity.RitemEntity;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class BomDto {

    private FitemEntity fitemEntity;
    private RitemEntity ritemEntity;
    private Long bomUseMt;
    private Time bomWorkTm;

    public BomEntity toEntity() {
        return new BomEntity(fitemEntity, ritemEntity, bomUseMt, bomWorkTm);
    }
}