package com.erpproject.sixbeam.hr.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RequiredArgsConstructor
@RequestMapping("/hr/vacation")
@Controller
public class VacationController {
    @GetMapping("/list")
    public String List() {
        return "contents/hr/vacation_list";
    }
}
