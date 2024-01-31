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
    @Column
    private int eiId;//사원아이디
    @Column
    private String eiPw;//사원비밀번호
    @Column
    private String eiNm;//사원이름
    @Column
    private boolean eiSex;//사원성별
    @Column
    private LocalDate eiBirth;//생일
    @Column
    private String eiAddr;//주소
    @Column
    private String eiPhone;//전화번호
    @Column
    private String eiEmail;//이메일
    @Column
    private LocalDate eiJoinDt;//입사일
    @Column
    private LocalDate eiQuitDt;//퇴사일
    @ManyToOne
    @JoinColumn(name="positionCd")
    private PositionEntity positionCd;//직책
    @ManyToOne
    @JoinColumn(name="departCd")
    private DepartEntity departCd;//붜
    @Column
    private String eiBank;//은행
    @Column
    private String eiAccountNumber;//계좌번호
    @Column
    private String eiQr;//퇴사사유
    @Column
    private int eiTotalNoy;//총연차수
    @Column
    private String eiEtc;//비고
}
