package com.erpproject.sixbeam.ac.dto;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.entity.PurEntity;
import com.erpproject.sixbeam.pur.entity.InputEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PurDto {
    private String purNb;
    private AccountEntity accountEntity;
    private InputEntity inputEntity;
    private int purPrice;
    private String purSubject;

    public PurEntity toEntity() {

        return new PurEntity(purNb, accountEntity, inputEntity.getInputPurCd(), purPrice, purSubject,inputEntity );
    }
}
