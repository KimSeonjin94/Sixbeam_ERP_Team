package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PD_FITEM_TB")
public class FitemEntity {

    @Id
    @Column(name = "FITEM_CD")
    private String fitemCd;


}