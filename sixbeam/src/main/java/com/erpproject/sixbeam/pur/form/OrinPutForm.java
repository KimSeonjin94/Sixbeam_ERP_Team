package com.erpproject.sixbeam.pur.form;

import com.erpproject.sixbeam.pur.dto.OrinPutDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class OrinPutForm {
    @Autowired
    private List<OrinPutDto> orinputDtos= new ArrayList<>();
}
