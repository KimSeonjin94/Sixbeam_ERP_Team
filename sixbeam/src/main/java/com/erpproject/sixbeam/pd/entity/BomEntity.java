package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "PD_BOM_TB")
@IdClass(BomEntityId.class)
public class BomEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "FITEM_CD")
    private FitemEntity fitemEntities;

    @Id
    @ManyToOne
    @JoinColumn(name = "RITEM_CD")
    private RitemEntity ritemEntity;

    @Column
    private int bomUseMt;

    @Column
    private Time bomWorkTm;
}

