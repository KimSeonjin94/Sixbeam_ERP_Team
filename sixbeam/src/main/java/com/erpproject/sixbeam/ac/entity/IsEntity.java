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
    @Column(name="IS_DT")
    private LocalDate isDt;
    @Column(name="IS_NET_SALES")
    private int isNetSales;
    @Column(name="IS_COST_SALES")
    private int isCostSales;
    @Column(name="IS_WAGES")
    private int isWages;
    @Column(name="IS_INTER_INC")
    private int isInterInc;
    @Column(name="IS_INTER_EXP")
    private int isInterExp;
    @Column(name="IS_CORTAX_EXP")
    private int isCortaxExp;

//    public IsEntity(LocalDate isDt, int isNetSales, int isCostSales, int isWages, int isInterInc, int isInterExp, int isCortaxExp) {
//        this.isDt = isDt;
//        this.isNetSales = isNetSales;
//        this.isCostSales = isCostSales;
//        this.isWages = isWages;
//        this.isInterInc = isInterInc;
//        this.isInterExp = isInterExp;
//        this.isCortaxExp = isCortaxExp;
//    }
}
