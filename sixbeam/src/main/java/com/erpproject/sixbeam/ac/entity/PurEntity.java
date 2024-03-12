package com.erpproject.sixbeam.ac.entity;


import com.erpproject.sixbeam.pur.entity.InputEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="AC_PUR_TB")
public class PurEntity {
    @Id
    @Column(name="PUR_NB",nullable = false)
    private String purNb;
    @ManyToOne
    @JoinColumn(name="ACCOUNT_CD")
    private AccountEntity accountEntity;
    @ManyToOne
    @JoinColumn(name="INPUTPUR_CD")
    private InputEntity inputEntity;
    @Column(name="PUR_PRICE")
    private int purPrice;
    @Column(name="PUR_SUBJECT",nullable = false)
    private String purSubject;

}
