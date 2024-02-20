package com.erpproject.sixbeam.pur.form;

import com.erpproject.sixbeam.pur.dto.InputDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
@Getter
public class InputForm {
    @Autowired
    private InputDto inputDtos;
}
