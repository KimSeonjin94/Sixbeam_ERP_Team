package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.pd.entity.FitemEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.RitemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pd.repository.RitemRepository;
import com.erpproject.sixbeam.pd.service.RitemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/pd/rawitem")
@RequiredArgsConstructor
@Controller
public class RitemController {

    private final RitemService ritemService;

    @GetMapping("/rawitemlist")
    public String saveRawItem(Model model) {
        List<RitemEntity> ritemEntities = ritemService.saveRawItems();
        model.addAttribute("ritemEntities", ritemEntities);
        return "contents/pd/rawitem_list";
    }
}