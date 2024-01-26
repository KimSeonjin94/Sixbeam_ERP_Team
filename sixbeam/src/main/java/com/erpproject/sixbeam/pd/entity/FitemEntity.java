package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class FitemEntity {

    @Id
    @OneToMany
    @Column(name ="", nullable = false)
    private ItemEntity itemEntity;
}
