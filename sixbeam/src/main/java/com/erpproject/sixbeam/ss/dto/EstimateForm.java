package com.erpproject.sixbeam.ss.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EstimateForm {
    @Autowired
    private List<EstimateDto> estimateDtos= new ArrayList<>();
}
