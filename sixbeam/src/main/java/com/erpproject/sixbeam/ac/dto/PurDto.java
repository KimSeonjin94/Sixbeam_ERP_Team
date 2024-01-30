package com.erpproject.sixbeam.ac.dto;

import com.erpproject.sixbeam.ac.entity.PurEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurDto {
    private String purNb;
    private String accountCd;
    private String piCd;
    private String purEtc;
    private String purSubject;
    private String salesBank;


    public PurEntity toEntity() {
        return new PurEntity(purNb, accountCd, piCd, purEtc, purSubject, salesBank);
    }
}
