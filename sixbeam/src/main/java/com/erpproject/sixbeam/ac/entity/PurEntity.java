package com.erpproject.sixbeam.ac.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="AC_PUR_TB")
public class PurEntity {
    @Id
    @Column(name="PUR_NB")
    private String purNb;
    @ManyToOne
    @JoinColumn(name="ACCOUNT_CD")
    private AccountEntity accountEntity;
    @ManyToOne
    @JoinColumn(name="PI_CD")
    private InputEntity inputEntity;
    @Column(name="PUR_ETC")
    private String purEtc;
    @Column(name="PUR_SUBJECT")
    private String purSubject;

}
