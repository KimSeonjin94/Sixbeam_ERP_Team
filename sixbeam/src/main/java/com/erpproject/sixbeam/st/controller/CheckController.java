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
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/st/check")
public class CheckController {

    private final CheckService checkService;

    @GetMapping("/checkamount")
    @ResponseBody
    public int getTotalCheckAmtByItemAndWhmoveUntilDate(@RequestParam("date") LocalDate date, @RequestParam("itemCd") String itemCd, @RequestParam("whmoveCd") String whmoveCd) {
        return checkService.getTotalCheckAmtByItemAndWhmoveUntilDate(date, itemCd, whmoveCd);
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/sixbeam/home";
    }
}
/*
    @GetMapping("/list")
    public String list(Model model) {
        List<CheckEntity> checkEntityList = this.checkService.getList();
        model.addAttribute("checkEntityList", checkEntityList);
        return "contents/st/check_list";
    }
*/




