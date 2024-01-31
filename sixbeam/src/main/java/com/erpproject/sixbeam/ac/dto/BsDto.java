package com.erpproject.sixbeam.ac.dto;

import com.erpproject.sixbeam.ac.entity.BsEntity;


import java.time.LocalDate;


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

    public BsEntity toEntity() {
        return new BsEntity(bsDt,  bsCash,  bsReceivables,  bsInventories,  bsLand,  bsBuilding,  bsFac,  bsPayables,  bsLongBor,  bsCapital,  bsEarnings);
    }
}
