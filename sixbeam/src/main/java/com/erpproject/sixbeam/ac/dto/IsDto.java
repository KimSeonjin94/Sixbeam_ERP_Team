package com.erpproject.sixbeam.ac.dto;

import com.erpproject.sixbeam.ac.entity.IsEntity;


import java.time.LocalDate;


public class IsDto {
    private String isDt;
    private int isNetSales;
    private int isCostSales;
    private int isWages;
    private int isInterInc;
    private int isInterExp;
    private int isCortaxExp;

    public IsEntity toEntity() {
        return new IsEntity(isDt, isNetSales, isCostSales, isWages, isInterInc, isInterExp, isCortaxExp);
    }
}
