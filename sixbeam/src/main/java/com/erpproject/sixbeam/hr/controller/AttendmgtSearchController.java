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
import java.time.LocalTime;
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
        List<ReasonEntity>reasonLists = this.reasonService.getList();
        model.addAttribute("reasonLists",reasonLists);
        return "contents/hr/attendmgtsearch_list";
    }
    @GetMapping("/create")
    public String display(@RequestParam("selectedDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate selectedDate, Model model) {
        List<WorkScheduleEntity> workScheduleList = workScheduleService.findByDateAndCheckTrue(selectedDate);
        model.addAttribute("workScheduleList", workScheduleList);
        List<ReasonEntity>reasonLists = this.reasonService.getList();
        model.addAttribute("reasonLists",reasonLists);
        return "contents/hr/attendmgtsearch_list :: attemdmgtsearchTable";
    }
    @PostMapping("/update")
    public String update(@RequestParam(value="workScheduleCd")Long workScheduleCd,
                         @RequestParam(value="empInfoId")EmpInfoEntity empInfoId,
                         @RequestParam(value="workScheduleCheck",required = false)boolean workScheduleCheck,
                         @RequestParam(value="workScheduleDate")LocalDate workScheduleDate,
                         @RequestParam(value="workScheduleStartTime") LocalTime workScheduleStartTime,
                         @RequestParam(value="workScheduleEndTime")LocalTime workScheduleEndTime,
                         @RequestParam(value="reasonCd")String workScheduleReason){
        this.workScheduleService.uudateAttendmgtsearch(
                workScheduleCd,
                empInfoId,
                workScheduleCheck,
                workScheduleDate,
                workScheduleStartTime,
                workScheduleEndTime,
                workScheduleReason
        );
        return "redirect:/hr/attendmgtsearch/list";
    }
}
