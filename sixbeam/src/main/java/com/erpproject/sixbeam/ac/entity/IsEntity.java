package com.erpproject.sixbeam.ac.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="AC_IS_TB")
public class IsEntity {

    @Id
    @Column(name="IS_DT" ,nullable = false)
    private String isDt;
    @Column(name="IS_NET_SALES", nullable = false)
    private int isNetSales;
    @Column(name="IS_COST_SALES" ,nullable = false)
    private int isCostSales;
    @Column(name="IS_WAGES" ,nullable = false)
    private int isWages;
    @Column(name="IS_INTER_INC",nullable = false)
    private int isInterInc;
    @Column(name="IS_INTER_EXP",nullable = false)
    private int isInterExp;
    @Column(name="IS_CORTAX_EXP",nullable = false)
    private int isCortaxExp;

}
