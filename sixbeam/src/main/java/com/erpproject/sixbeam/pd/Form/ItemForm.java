package com.erpproject.sixbeam.pd.Form;

import com.erpproject.sixbeam.pd.dto.ItemDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class ItemForm {

    private final List<ItemDto> itemDtos = new ArrayList<>();
}
