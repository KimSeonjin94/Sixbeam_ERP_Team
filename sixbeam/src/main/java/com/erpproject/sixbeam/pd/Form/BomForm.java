package com.erpproject.sixbeam.pd.Form;

import com.erpproject.sixbeam.pd.dto.BomDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class BomForm {

    private final List<BomDto> bomDtos = new ArrayList<>();
}
