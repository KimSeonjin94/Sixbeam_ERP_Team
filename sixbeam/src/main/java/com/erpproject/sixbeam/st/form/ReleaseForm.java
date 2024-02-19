package com.erpproject.sixbeam.st.form;

import com.erpproject.sixbeam.st.dto.ReleaseDto;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class ReleaseForm {
    private final List<ReleaseDto> releaseDtos = new ArrayList<>();
}
