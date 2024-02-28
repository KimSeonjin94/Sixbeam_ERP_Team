package com.erpproject.sixbeam.pd.Form;

import com.erpproject.sixbeam.pd.dto.OrderDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderForm {

    private List<OrderDto> orderDtos = new ArrayList<>();
}
