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
        List<WorkScheduleEntity> workScheduleLists = this.workScheduleService.findByDate(LocalDate.now());
        model.addAttribute("workScheduleLists", workScheduleLists);
        return "contents/hr/workSchedule_list";
    }

    @GetMapping("/create")
    public String displayWorkSchedule(@RequestParam("selectedDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate selectedDate, Model model) {
        List<WorkScheduleEntity> workScheduleList = workScheduleService.findByDate(selectedDate);
        model.addAttribute("workScheduleLists", workScheduleList);
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
        List<WorkScheduleEntity> exist = workScheduleRepository.findByWorkScheduleDateAndEmpInfoEntity_EmpInfoId(LocalDate.now(), empInfoId);

        if (!exist.isEmpty()) {
            WorkScheduleEntity existingEntity = exist.get(0); // 예시로 첫 번째 엔터티를 가져왔습니다. 필요에 따라 로직 수정
            existingEntity.setWorkScheduleStartTime(LocalTime.parse(currentTime));

            // currentTime이 09:00:00을 넘었는지 확인하여 workScheduleCheck 설정
            LocalTime targetTime = LocalTime.parse("09:00:00");
            if (LocalTime.parse(currentTime).compareTo(targetTime) > 0) {
                existingEntity.setWorkScheduleCheck(true);
            } else {
                existingEntity.setWorkScheduleCheck(false);
            }

            workScheduleRepository.save(existingEntity);
        } else {
            workScheduleEntity.setEmpInfoEntity(empp);
            workScheduleEntity.setWorkScheduleDate(LocalDate.now()); // 출근 또는 퇴근 시점의 날짜
            workScheduleEntity.setWorkScheduleCheck(false); // 출퇴근 기록 체크 로직은 필요에 따라 추가
            workScheduleEntity.setWorkScheduleStartTime(LocalTime.parse(currentTime));

            // currentTime이 09:00:00을 넘었는지 확인하여 workScheduleCheck 설정
            LocalTime targetTime = LocalTime.parse("09:00:00");
            if (LocalTime.parse(currentTime).compareTo(targetTime) > 0) {
                workScheduleEntity.setWorkScheduleCheck(true);
            } else {
                workScheduleEntity.setWorkScheduleCheck(false);
            }

            workScheduleRepository.save(workScheduleEntity);
        }
        // 성공적으로 기록되었을 때 응답
        return ResponseEntity.ok("처리되었습니다.");
    }
    @PostMapping("/recordLeaveWork")
    public ResponseEntity<String> recordLeaveWork(@RequestParam("currentTime") String currentTime) {
        // 현재 로그인한 사용자의 EmpInfoEntity를 가져오는 로직이 필요할 수 있습니다.
        // 이 부분은 세션 또는 사용자 인증에 따라 다르게 처리될 수 있습니다.
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Long empInfoId = Long.parseLong(username);
        Optional<EmpInfoEntity> emp = empInfoRepository.findByEmpInfoId(empInfoId);
        EmpInfoEntity empp = emp.get();
        WorkScheduleEntity workScheduleEntity = new WorkScheduleEntity();
        List<WorkScheduleEntity> exist = workScheduleRepository.findByWorkScheduleDateAndEmpInfoEntity_EmpInfoId(LocalDate.now(), empInfoId);

        if (!exist.isEmpty()) {
            WorkScheduleEntity existingEntity = exist.get(0); // 예시로 첫 번째 엔터티를 가져왔습니다. 필요에 따라 로직 수정
            existingEntity.setWorkScheduleEndTime(LocalTime.parse(currentTime));

            // currentTime이 18:00 이전이면 workScheduleCheck를 true로 설정
            LocalTime targetTime = LocalTime.parse("18:00:00");
            if (LocalTime.parse(currentTime).isBefore(targetTime)) {
                existingEntity.setWorkScheduleCheck(true);
            } else {
                existingEntity.setWorkScheduleCheck(false);
            }

            workScheduleRepository.save(existingEntity);
        } else {
            workScheduleEntity.setEmpInfoEntity(empp);
            workScheduleEntity.setWorkScheduleDate(LocalDate.now()); // 출근 또는 퇴근 시점의 날짜
            workScheduleEntity.setWorkScheduleCheck(false); // 출퇴근 기록 체크 로직은 필요에 따라 추가
            workScheduleEntity.setWorkScheduleEndTime(LocalTime.parse(currentTime));

            // currentTime이 18:00 이전이면 workScheduleCheck를 true로 설정
            LocalTime targetTime = LocalTime.parse("18:00:00");
            if (LocalTime.parse(currentTime).isBefore(targetTime)) {
                workScheduleEntity.setWorkScheduleCheck(true);
            } else {
                workScheduleEntity.setWorkScheduleCheck(false);
            }

            workScheduleRepository.save(workScheduleEntity);
        }
        return ResponseEntity.ok("처리되었습니다.");
    }
    @GetMapping("/myAttendenceRecord")
    public String  myAttendenceRecord(@RequestParam("selectedDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate selectedDate, Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Long empInfoId = Long.parseLong(username);
        List<WorkScheduleEntity>workScheduleOne =workScheduleRepository.findByWorkScheduleDateAndEmpInfoEntity_EmpInfoId(selectedDate,empInfoId);
        model.addAttribute("workScheduleLists",workScheduleOne);
        return "contents/home/check_form :: workScheduleOneOne";
    }
}
