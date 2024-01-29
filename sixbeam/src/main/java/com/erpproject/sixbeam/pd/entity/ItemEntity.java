package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "PD_RITEM_TB")
public class RitemEntity {

    @Id
    @Column(name = "RITEM_CD")
    private String ritemCd;

    // BomEntity와 연관되어있음
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "fitem_entity_id", referencedColumnName = "fitem_entity_id"),
            @JoinColumn(name = "ritementity_id", referencedColumnName = "ritementity_id")
    })
    private BomEntity bomEntity;
}