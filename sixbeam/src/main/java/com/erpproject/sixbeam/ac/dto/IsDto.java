package com.erpproject.sixbeam.ac.dto;

import com.erpproject.sixbeam.ac.entity.IsEntity;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
public class IsDto {
    private String isDt;
    private long isNetSales;
    private long isCostSales;
    private long isWages;
    private long isInterInc;
    private long isInterExp;
    private long isCortaxExp;

    public IsEntity toEntity() {
        return new IsEntity(isDt, isNetSales, isCostSales, isWages, isInterInc, isInterExp, isCortaxExp);
    }
}
