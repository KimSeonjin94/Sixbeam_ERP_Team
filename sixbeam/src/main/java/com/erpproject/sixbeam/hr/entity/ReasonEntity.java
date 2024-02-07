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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="HR_REASON_TB_reasonCd_seq")
    @SequenceGenerator(name ="HR_REASON_TB_reasonCd_seq", sequenceName = "HR_REASON_TB_reasonCd_seq",
    initialValue =401 ,allocationSize = 1)
    @Column(name = "reasonCd")
    private Long reasonCd;//사유코드;
    @Column(name = "reasonNM")
    private String reasonNm;//사유명;

}
