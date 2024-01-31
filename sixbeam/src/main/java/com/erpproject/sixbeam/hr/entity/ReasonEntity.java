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
@Table(name="HR_REASON_TB")
public class ReasonEntity {
    @Id
    private int reasonCd;//사유코드;
    @Column
    private String reasonNm;//사유명;

}
