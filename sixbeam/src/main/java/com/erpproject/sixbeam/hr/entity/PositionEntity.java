package com.erpproject.sixbeam.hr.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="HR_POSITION_TB")
public class PositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="HR_POSITION_TB_positionCd_seq")
    @SequenceGenerator(name ="HR_POSITION_TB_positionCd_seq", sequenceName ="HR_POSITION_TB_positionCd_seq",
            initialValue = 308, allocationSize =1)
    @Column(name ="positionCd")
    private Long positionCd;//직책코드
    @Column(name ="positionNm")
    private String positionNm;//직책명
}
