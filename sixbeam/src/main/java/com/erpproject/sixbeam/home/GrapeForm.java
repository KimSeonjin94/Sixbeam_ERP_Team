package com.erpproject.sixbeam.home;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GrapeForm {
    private List<GrapeSale> grapeSales;
    private List<PreGrape> preGrapes;
}
