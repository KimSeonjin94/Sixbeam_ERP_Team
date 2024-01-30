package com.erpproject.sixbeam.ac.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class IsDto {
    private LocalDate isDt;
    private int isNetSales;
    private int isCostSales;
    private int isWages;
    private int isInterInc;
    private int isInterExp;
    private int isCortaxExp;
}
