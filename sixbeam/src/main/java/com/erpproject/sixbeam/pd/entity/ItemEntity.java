package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
public class ItemEntity {

    @Id
    @ManyToOne
    @Column(name ="", nullable = false)
    private List<ItemEntity> itemEntity;
}
