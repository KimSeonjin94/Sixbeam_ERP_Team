package com.erpproject.sixbeam.pur.dto;

import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;

import java.time.LocalDate;

public class InputDto {
    private LocalDate purDt;
    private String piCd;
    private OrinPutEntity orinputEntity;
    private WhmoveEntity whmoveEntity;
    private String purProgSt;
    private LocalDate slipIssuDt;
    private boolean slipIssuFl;
}
