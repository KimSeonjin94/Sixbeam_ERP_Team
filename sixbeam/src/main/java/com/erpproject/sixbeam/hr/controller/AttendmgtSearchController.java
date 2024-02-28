package com.erpproject.sixbeam.hr.controller;

import com.erpproject.sixbeam.hr.entity.*;
import com.erpproject.sixbeam.hr.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/hr/attendmgtsearch")
@Controller
public class AttendmgtSearchController {
    @Autowired
    private final WorkScheduleService workScheduleService;
    @Autowired
    private final ReasonService reasonService;

    @GetMapping("/list")
    public String List(Model model) {
        List<WorkScheduleEntity> workScheduleLists = this.workScheduleService.getList();
        model.addAttribute("workScheduleLists", workScheduleLists);
        List<ReasonEntity>reasonList = this.reasonService.getList();
        model.addAttribute("reasonList",reasonList);
        return "contents/hr/attendmgtsearch_list";
    }
    @PostMapping("/create")
    public String display(@RequestParam("selectedDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate selectedDate, Model model) {
        List<WorkScheduleEntity> workScheduleList = workScheduleService.findByDateAndCheckTrue(selectedDate);
        model.addAttribute("workScheduleList", workScheduleList);
        return "contents/hr/attendmgtsearch_list";
    }
}
