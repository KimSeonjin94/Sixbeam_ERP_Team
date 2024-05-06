package com.erpproject.sixbeam.pd.entity;

import com.erpproject.sixbeam.pd.repository.ItemRepository;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "pd_fitem_tb")
public class FitemEntity {

    @Id
    @Column(name = "item_cd", insertable = false, updatable = false)
    private String itemCd;

    @Column(name = "item_nm")
    private String itemNm;

    @Column(name = "item_stnd")
    private String itemStnd;

    @Column(name = "item_up")
    private Long itemUp;
}