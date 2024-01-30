package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PD_RITEM_TB")
public class RitemEntity {

    @Id
    @Column(name = "RITEM_CD")
    private String ritemCd;



}