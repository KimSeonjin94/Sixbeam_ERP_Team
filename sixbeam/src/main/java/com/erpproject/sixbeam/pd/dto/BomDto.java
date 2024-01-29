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

    @Id
    @OneToMany
    @JoinColumn(name="fItemCd")
    private String finishItemCd;
    @Id
    @OneToMany
    @JoinColumn(name = "rItemCd")
    private String rawItemCd;
    @Column
    private int bomUseMt;
    @Column
    private Time bomWorkTm;

    public BomEntity toEntity() {
        return new BomEntity(finishItemCd, rawItemCd, bomUseMt, bomWorkTm);
    }
}
