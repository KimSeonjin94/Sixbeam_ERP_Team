package com.erpproject.sixbeam.pd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
public class BomEntityId implements Serializable {

    private FitemEntity fitemEntity;
    private RitemEntity ritemEntity;
}
