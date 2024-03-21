package com.erpproject.sixbeam.ac.dto;

import com.erpproject.sixbeam.ac.entity.BsEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BsDto {
    private String bsDt;
    private long bsCash;
    private long bsReceivables;
    private long bsInventories;
    private long bsLand;
    private long bsBuilding;
    private long bsFac;
    private long bsPayables;
    private long bsLongBor;
    private long bsCapital;
    private long bsEarnings;

    public BsEntity toEntity() {
        return new BsEntity(bsDt,  bsCash,  bsReceivables,  bsInventories,  bsLand,  bsBuilding,  bsFac,  bsPayables,  bsLongBor,  bsCapital,  bsEarnings);
    }
}
