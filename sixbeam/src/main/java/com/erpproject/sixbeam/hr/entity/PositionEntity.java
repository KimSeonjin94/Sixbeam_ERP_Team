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
    private int positionCd;//직책코드
    @Column
    private String positionNm;//직책명
}
