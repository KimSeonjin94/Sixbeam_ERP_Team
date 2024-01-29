package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.List;

@Entity
public class BomEntity {

    @Id
    @OneToMany(mappedBy = "bomEntity")
    @JoinColumn(name = "")
    private List<FitemEntity> fitemEntities;
    @Id
    @OneToMany
    @JoinColumn(name = "rItemCd")
    private String rawItemCd;
    @Column
    private int bomUseMt;
    @Column
    private Time bomWorkTm;
}
