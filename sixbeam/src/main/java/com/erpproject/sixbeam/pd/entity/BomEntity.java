package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.sql.Time;

@Entity
public class BomEntity {

    @Id
    @ManyToOne
    @Column(name = "fitemEntity", nullable = false)
    private FitemEntity fitemEntity; // 완품 품목코드

    @Id
    @ManyToOne
    @Column(name = "ritemEntity", nullable = false)
    private RitemEntity ritemEntity; // 단품 품목코드

    @Column(name ="", nullable = false)
    private int bomUseMt; // 원재료 소모수

    @Column(name ="", nullable = false)
    private Time bomWorkTm; // 작업소요시간


}
