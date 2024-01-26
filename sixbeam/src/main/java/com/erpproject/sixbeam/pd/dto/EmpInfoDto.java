package com.erpproject.sixbeam.pd.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmpInfoDto {
    private String EI_ID;
    private String EI_PW;
    private String EI_NM;
    private boolean EI_SEX;
    private LocalDate EI_BIRTH;
    private String EI_ADDR;
    private String EI_PHONE;
    private String EI_EMAIL;
    private LocalDate EI_JOIN_DT;
    private LocalDate EI_QUIT_DT;
    private String EI_POSITION_CD;
    private String EI_DEPART_CD;
    private String EI_BANK;
    private String EI_ACCOUNT_NO;
    private String EI_QR;
    private int EI_TOTALNOY;
    private String EI_ETC;
}
