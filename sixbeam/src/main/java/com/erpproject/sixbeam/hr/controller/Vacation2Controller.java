package com.erpproject.sixbeam.hr.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hr")
@RequiredArgsConstructor
@Controller
public class Vacation2Controller {
    @GetMapping("/vvacation")
    public String Vacation(Model model){
        return "contents/hr/vacation_list";
    }
}
