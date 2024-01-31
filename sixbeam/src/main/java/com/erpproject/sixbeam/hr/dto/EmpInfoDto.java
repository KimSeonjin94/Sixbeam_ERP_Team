package com.erpproject.sixbeam.hr.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmpInfoDto {
    private int eiId;//사원아이디
    private String eiPw;//사원비밀번호
    private String eiNm;//사원이름
    private boolean eiSex;//사원성별
    private LocalDate eiBirth;//생일
    private String eiAddr;//주소
    private String eiPhone;//전화번호
    private String eiEmail;//이메일
    private LocalDate eiJoinDt;//입사일
    private LocalDate eiQuitDt;//퇴사일
    private int positionCd;//직책
    private int departmentCd;//부서
    private String eiBank;//은행
    private String eiAccountNumber;//계좌번호
    private String eiQr;//퇴사사유
    private int eiTotalNoy;//총연차수
    private String eiEtc;//비고
}