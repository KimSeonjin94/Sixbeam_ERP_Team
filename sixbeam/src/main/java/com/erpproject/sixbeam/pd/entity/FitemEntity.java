package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PD_FITEM_TB")
public class FitemEntity {

    @Id
    @Column(name = "FITEM_CD")
    private String fitemCd;

    // BomEntity와 연관되어있음
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "fitem_entity_id", referencedColumnName = "fitem_entity_id"),
            @JoinColumn(name = "ritementity_id", referencedColumnName = "ritementity_id")
    })
    private BomEntity bomEntity;
}