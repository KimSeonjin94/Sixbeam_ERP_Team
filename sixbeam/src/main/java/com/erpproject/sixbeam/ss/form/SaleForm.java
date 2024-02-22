package com.erpproject.sixbeam.ss.form;

import com.erpproject.sixbeam.ss.dto.SaleDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SaleForm {
    List<SaleDto> saleDtos=new ArrayList<>();
}
