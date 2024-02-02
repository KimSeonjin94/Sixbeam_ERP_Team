package com.erpproject.sixbeam.hr.dto;


import com.erpproject.sixbeam.hr.entity.DepartEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.entity.PositionEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmpInfoDto {
    private Long empInfoId;//사원아이디
    private String empInfoPw;//사원비밀번호
    private String empInfoNm;//사원이름
    private boolean empInfoSex;//사원성별s
    private LocalDate empInfoBirth;//생일
    private String empInfoAddr;//주소
    private String empInfoPhone;//전화번호
    private String empInfoEmail;//이메일
    private LocalDate empInfoJoinDt;//입사일
    private LocalDate empInfoQuitDt;//퇴사일
    private PositionEntity positionEntity;//직책
    private DepartEntity departEntity;//부서
    private String empInfoBank;//은행
    private String empInfoAccountNo;//계좌번호
    private String empInfoQr;//퇴사사유
    private int empInfoTotalnoy;//총연차수
    private String empInfoEtc;//비고

    public EmpInfoEntity toEntity() {
        return new EmpInfoEntity(empInfoId, empInfoPw, empInfoNm, empInfoSex,
                empInfoBirth, empInfoAddr, empInfoPhone, empInfoEmail, empInfoJoinDt,
                empInfoQuitDt, positionEntity, departEntity, empInfoBank, empInfoAccountNo,
                empInfoQr, empInfoTotalnoy, empInfoEtc);
    }
}