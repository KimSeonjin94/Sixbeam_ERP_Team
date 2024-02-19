package com.erpproject.sixbeam.st.form;

import com.erpproject.sixbeam.st.dto.WhregistDto;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class WhregistForm {
    private final List<WhregistDto> whregistDtos = new ArrayList<>();
}
