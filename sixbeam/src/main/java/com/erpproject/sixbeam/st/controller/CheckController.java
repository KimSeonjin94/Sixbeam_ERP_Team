package com.erpproject.sixbeam.st.controller;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.service.CheckService;
import com.erpproject.sixbeam.st.entity.CheckEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/st/check")
public class CheckController {

    public final CheckService checkService;

    @GetMapping("/")
    public String root() {
        return "redirect:/sixbeam/home";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<CheckEntity> checkEntityList = this.checkService.getList();
        model.addAttribute("checkEntityList", checkEntityList);
        return "contents/st/check_list";
    }
    @GetMapping("/checkamount")
    public int getAmountByDate(@RequestParam WhmoveEntity whmoveEntity, @RequestParam ItemEntity itemEntity,@RequestParam LocalDate date) {
        return checkService.getAmountByDate(whmoveEntity,itemEntity,date);
    }
}
