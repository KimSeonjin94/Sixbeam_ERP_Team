package com.erpproject.sixbeam.hr.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="HR_DEPART_TB")
public class DepartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "HR_DEPART_TB_departCd_seq")
    @SequenceGenerator(name = "HR_DEPART_TB_departCd_seq", sequenceName = "HR_DEPART_TB_departCd_seq",
            initialValue = 101, allocationSize = 1)
    @Column(name = "departCd")
    private Long departCd;//부서코드
    @Column(name = "departNm")
    private String departNm;//부서이름


}
