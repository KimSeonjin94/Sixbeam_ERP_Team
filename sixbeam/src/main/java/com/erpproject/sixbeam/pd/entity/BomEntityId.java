package com.erpproject.sixbeam.pd.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BomEntityId implements Serializable {
    private FitemEntity fitemEntities;
    private RitemEntity ritemEntity;

    // 생성자, equals, hashCode 등을 구현해야 합니다.

    // getters, setters
}
