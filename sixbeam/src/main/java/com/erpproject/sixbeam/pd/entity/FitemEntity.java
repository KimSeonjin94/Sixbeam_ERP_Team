package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.*;

@Entity
public class FitemEntity {

    @Id
    @OneToMany
    @Column(name = "", nullable = false)
    private FitemEntity fitemEntity;

    @ManyToOne
    @Column(name = "")
    private BomEntity bomEntity;
}
