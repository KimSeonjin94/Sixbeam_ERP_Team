package com.erpproject.sixbeam.hr.controller;

import com.erpproject.sixbeam.hr.entity.WorkScheduleEntity;
import com.erpproject.sixbeam.hr.service.WorkScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/hr/workSchedule")
@Controller
public class WorkScheduleController {
    @Autowired
    private final WorkScheduleService workScheduleService;

    @GetMapping("/list")
    public String List(Model model) {
        List<WorkScheduleEntity> workScheduleLists = this.workScheduleService.getList();
        model.addAttribute("workScheduleLists", workScheduleLists);
        return "contents/hr/workSchedule_list";
    }

    @PostMapping("/create")
    public String displayWorkSchedule(@RequestParam("selectedDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate selectedDate, Model model) {
        List<WorkScheduleEntity> workScheduleList = workScheduleService.findByDate(selectedDate);
        model.addAttribute("workScheduleList", workScheduleList);
        return "contents/hr/workSchedule_list :: workScheduleTable"; // Thymeleaf fragment 경로 지정
    }
    @PostMapping("/update")
    public String update(@RequestParam("selectedDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate workScheduleDate,
                         @RequestParam("current[0].id") Long empinfoId,
                         @RequestParam("reasonCd") String workScheduleReason) {

        workScheduleService.updateReasonForWorkSchedule(workScheduleDate, empinfoId, workScheduleReason);

        return "redirect:/hr/workSchedule/list";
    }
}
