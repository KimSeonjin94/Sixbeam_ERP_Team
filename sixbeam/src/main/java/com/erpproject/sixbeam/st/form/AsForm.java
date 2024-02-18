package com.erpproject.sixbeam.st.form;

import com.erpproject.sixbeam.st.dto.AsDto;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class AsForm {
    private final List<AsDto> asDtos = new ArrayList<>();
}
