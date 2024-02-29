package com.erpproject.sixbeam.pd.dto;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.InoutEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.OrderEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Getter
@Setter
public class InoutDto {

    private String inoutCmptCd;
    private EmpInfoEntity empInfoEntity;
    private OrderEntity orderEntity;
    private LocalDate inoutDt;
    private WhregistEntity whregistEntity;
    private ItemEntity itemEntity;

    public InoutEntity toEntity() {
        return new InoutEntity(inoutCmptCd, empInfoEntity, orderEntity, inoutDt, whregistEntity, itemEntity);
    }
}