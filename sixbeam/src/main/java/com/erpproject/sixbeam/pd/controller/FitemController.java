package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.pd.entity.FitemEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.FitemRepository;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pd.service.FitemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/pd/finitem")
@RequiredArgsConstructor
@Controller
public class FitemController {

    private final FitemService fitemService;

    @GetMapping("/finitemlist")
    public String saveFinItem(Model model) {

        List<FitemEntity> fitemEntities = fitemService.saveFinItems();

        model.addAttribute("fitemEntities", fitemEntities);

        return "contents/pd/finitem_list";
    }
}