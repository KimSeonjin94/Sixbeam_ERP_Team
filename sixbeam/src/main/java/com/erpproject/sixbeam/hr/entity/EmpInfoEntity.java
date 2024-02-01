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
    @Column(name ="empInfoId")
    private String empInfoId;//사원아이디
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="HR_EMPINFO_TB_empSequence_seq")
    @SequenceGenerator(name ="HR_EMPINFO_TB_empSequence_seq", sequenceName ="HR_EMPINFO_TB_empSequence_seq",
            initialValue = 1001, allocationSize =1)
    private Long empSequence;//사원순서
    @Column(name ="empInfoPw")
    private String empInfoPw;//사원비밀번호
    @Column(name ="empInfoNm")
    private String empInfoNm;//사원이름
    @Column(name ="empInfoSex")
    private boolean empInfoSex;//사원성별
    @Column(name ="empInfoBirth")
    private LocalDate empInfoBirth;//생일
    @Column(name ="empInfoAddr")
    private String empInfoAddr;//주소
    @Column(name ="empInfoPhone")
    private String empInfoPhone;//전화번호
    @Column(name ="empInfoEmail")
    private String empInfoEmail;//이메일
    @Column(name ="empInfoJoinDt")
    private LocalDate empInfoJoinDt;//입사일
    @Column(name ="empInfoQuitDt")
    private LocalDate empInfoQuitDt;//퇴사일
    @ManyToOne
    @JoinColumn(name="positionCd")
    private PositionEntity positionEntity;//직책
    @ManyToOne
    @JoinColumn(name="departCd")
    private DepartEntity departEntity;//붜
    @Column(name ="empInfoBank")
    private String empInfoBank;//은행
    @Column(name ="empInfoAccountNo")
    private String empInfoAccountNo;//계좌번호
    @Column(name ="empInfoQr")
    private String empInfoQr;//퇴사사유
    @Column(name ="empInfoTotalnoy")
    private int empInfoTotalnoy;//총연차수
    @Column(name="empInfoEtc")
    private String empInfoEtc;//비고

}
