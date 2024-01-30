package com.erpproject.sixbeam.ac.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BsDto {
    private LocalDate bsDt;
    private int bsCash;
    private int bsReceivables;
    private int bsInventories;
    private int bsLand;
    private int bsBuilding;
    private int bsFac;
    private int bsPayables;
    private int bsLongBor;
    private int bsCapital;
    private int bsEarnings;
}
