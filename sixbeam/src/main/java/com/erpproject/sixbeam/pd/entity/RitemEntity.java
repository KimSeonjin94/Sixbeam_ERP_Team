package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class RitemEntity {

    @Id
    @OneToMany
    @Column(name ="", nullable = false)
    private List<FitemEntity> fitemEntities;

}
