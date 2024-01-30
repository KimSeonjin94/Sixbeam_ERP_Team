package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class InoutEntity {

    @Id
    @OneToOne
    @Column(name ="", nullable = false)
    private InoutEntity inoutEntity;

    @Column(name ="", nullable = false)
    private String eiId;

    @Column(name ="", nullable = false)
    private String whMoveCd;

}
