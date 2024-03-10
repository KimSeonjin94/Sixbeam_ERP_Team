package com.erpproject.sixbeam.hr.controller;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.entity.WorkScheduleEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.hr.repository.WorkScheduleRepository;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import com.erpproject.sixbeam.hr.service.WorkScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RequestMapping("/hr/workSchedule")
@Controller
public class WorkScheduleController {
    @Autowired
    private final WorkScheduleService workScheduleService;
    private final WorkScheduleRepository workScheduleRepository;
    private final EmpInfoRepository empInfoRepository;

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
    @PostMapping("/find")
    public void find(LocalDate workScheduleDate, Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Long empInfoId = Long.parseLong(username);
        List<WorkScheduleEntity>workScheduleEntity= workScheduleRepository.findByWorkScheduleDateAndEmpInfoEntity_EmpInfoId(workScheduleDate,empInfoId);
        model.addAttribute("workScheduleOne",workScheduleEntity);
    }
    @PostMapping("/recordAttendance")
    public ResponseEntity<String> recordAttendance(@RequestParam("currentTime") String currentTime) {
        // 현재 로그인한 사용자의 EmpInfoEntity를 가져오는 로직이 필요할 수 있습니다.
        // 이 부분은 세션 또는 사용자 인증에 따라 다르게 처리될 수 있습니다.
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Long empInfoId = Long.parseLong(username);
        Optional<EmpInfoEntity> emp = empInfoRepository.findByEmpInfoId(empInfoId);
        EmpInfoEntity empp = emp.get();
        WorkScheduleEntity workScheduleEntity = new WorkScheduleEntity();
        List<WorkScheduleEntity>exist = workScheduleRepository.findByWorkScheduleDateAndEmpInfoEntity_EmpInfoId(LocalDate.now(),empInfoId);
        if(!exist.isEmpty()){
            WorkScheduleEntity existingEntity = exist.get(0); // 예시로 첫 번째 엔터티를 가져왔습니다. 필요에 따라 로직 수정
            existingEntity.setWorkScheduleStartTime(LocalTime.parse(currentTime));
            workScheduleRepository.save(existingEntity);
        }
        else{
            workScheduleEntity.setEmpInfoEntity(empp);
            workScheduleEntity.setWorkScheduleDate(LocalDate.now()); // 출근 또는 퇴근 시점의 날짜
            workScheduleEntity.setWorkScheduleCheck(false); // 출퇴근 기록 체크 로직은 필요에 따라 추가
            workScheduleEntity.setWorkScheduleStartTime(LocalTime.parse(currentTime));
            workScheduleRepository.save(workScheduleEntity);
        }
        // 성공적으로 기록되었을 때 응답
        return ResponseEntity.ok("처리되었습니다.");
    }
//    @PostMapping("/recordLeaveWork")
//    public ResponseEntity<String> recordLeaveWork(@RequestParam("currentTime") String currentTime) {
//        // 현재 로그인한 사용자의 EmpInfoEntity를 가져오는 로직이 필요할 수 있습니다.
//        // 이 부분은 세션 또는 사용자 인증에 따라 다르게 처리될 수 있습니다.
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        Long empInfoId = Long.parseLong(username);
//        Optional<EmpInfoEntity> emp = empInfoRepository.findByEmpInfoId(empInfoId);
//        EmpInfoEntity empp = emp.get();
//        Optional<WorkScheduleEntity> existingWorkSchedule = workScheduleRepository
//                .findByEmpInfoEntity_EmpInfoIdAndWorkScheduleDate(empp, LocalDate.now());
//        if(existingWorkSchedule.isPresent()){
//            WorkScheduleEntity workScheduleEntity = existingWorkSchedule.get();
//            workScheduleEntity.setEmpInfoEntity(empp);
//            workScheduleEntity.setWorkScheduleDate(LocalDate.now()); // 출근 또는 퇴근 시점의 날짜
//            workScheduleEntity.setWorkScheduleCheck(false); // 출퇴근 기록 체크 로직은 필요에 따라 추가
//            workScheduleEntity.setWorkScheduleEndTime(LocalTime.parse(currentTime));
//            workScheduleRepository.save(workScheduleEntity);
//            return ResponseEntity.ok("퇴근이 기록되었습니다.");
//        }else{
//            WorkScheduleEntity workScheduleEntity = new WorkScheduleEntity();
//            workScheduleEntity.setEmpInfoEntity(empp);
//            workScheduleEntity.setWorkScheduleDate(LocalDate.now()); // 출근 또는 퇴근 시점의 날짜
//            workScheduleEntity.setWorkScheduleCheck(false); // 출퇴근 기록 체크 로직은 필요에 따라 추가
//            workScheduleEntity.setWorkScheduleEndTime(LocalTime.parse(currentTime));
//            workScheduleRepository.save(workScheduleEntity);
//            ResponseEntity.badRequest().body("출근 기록이 없습니다.");
//        }
//        return ResponseEntity.badRequest().body("사용자를 찾을 수 없습니다.");
//    }
}
