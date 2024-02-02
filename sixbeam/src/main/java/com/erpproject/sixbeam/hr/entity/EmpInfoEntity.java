package com.erpproject.sixbeam.hr.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="HR_EMPINFO_TB")

public class EmpInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="HR_EMPINFO_TB_empSequence_seq")
    @SequenceGenerator(name ="HR_EMPINFO_TB_empSequence_seq", sequenceName ="HR_EMPINFO_TB_empSequence_seq",
            initialValue = 20241001, allocationSize =1)
    @Column(name ="empinfoId")
    private Long empInfoId;//사원아이디
    @Column(name ="empinfoPw")
    private String empInfoPw;//사원비밀번호
    @Column(name ="empinfoNm")
    private String empInfoNm;//사원이름
    @Column(name ="empinfoSex")
    private boolean empInfoSex;//사원성별
    @Column(name ="empinfoBirth")
    private LocalDate empInfoBirth;//생일
    @Column(name ="empinfoAddr")
    private String empInfoAddr;//주소
    @Column(name ="empinfoPhone")
    private String empInfoPhone;//전화번호
    @Column(name ="empinfoEmail")
    private String empInfoEmail;//이메일
    @Column(name ="empinfoJoinDt")
    private LocalDate empInfoJoinDt;//입사일
    @Column(name ="empinfoQuitDt")
    private LocalDate empInfoQuitDt;//퇴사일
    @ManyToOne
    @JoinColumn(name="positionCd")
    private PositionEntity positionEntity;//직책
    @ManyToOne
    @JoinColumn(name="departCd")
    private DepartEntity departEntity;//붜
    @Column(name ="empinfoBank")
    private String empInfoBank;//은행
    @Column(name ="empinfoAccountNo")
    private String empInfoAccountNo;//계좌번호
    @Column(name ="empinfoQr")
    private String empInfoQr;//퇴사사유
    @Column(name ="empinfoTotalnoy")
    private int empInfoTotalnoy;//총연차수
    @Column(name="empinfoEtc")
    private String empInfoEtc;//비고

}
