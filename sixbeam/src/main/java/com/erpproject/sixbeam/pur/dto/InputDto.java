package com.erpproject.sixbeam.pur.dto;

import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class InputDto {
    private LocalDate inputPurDt;
    private String inputPurCd;
    private OrinPutEntity orinputEntity;
    private WhregistEntity whregistEntity;
    private String inputPrgSt;
    private LocalDate inputSiDt;
    private boolean inputSiFl;
    private String etc;

    public InputEntity toEntity() {
        InputEntity entity = new InputEntity();

        // Entity에 값을 설정하는 부분
        entity.setInputPurDt(this.inputPurDt);
        entity.setOrinputEntity(this.orinputEntity);
        entity.setWhregistEntity(this.whregistEntity);
        entity.setInputPrgSt(this.inputPrgSt);
        entity.setInputSiDt(this.inputSiDt);
        entity.setInputSiFl(this.inputSiFl);
        return entity;
    }
}
