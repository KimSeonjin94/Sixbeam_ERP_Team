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
    @Column
    private int departCd;//부서코드
    @Column
    private String departNm;//부서이름
}
