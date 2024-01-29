package com.erpproject.sixbeam.pd.dto;

import com.erpproject.sixbeam.pd.entity.BomEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class BomDto {

    private String finishItemCd;
    private String rawItemCd;
    private int bomUseMt;
    private Time bomWorkTm;

    public BomEntity toEntity() {
        return new BomEntity(finishItemCd, rawItemCd, bomUseMt, bomWorkTm);
    }
}
