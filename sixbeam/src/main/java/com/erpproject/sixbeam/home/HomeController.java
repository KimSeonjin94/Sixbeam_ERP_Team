package com.erpproject.sixbeam.home;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import com.erpproject.sixbeam.pur.service.OrinPutService;
import com.erpproject.sixbeam.ss.service.EstimateService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequestMapping("/sixbeam")
@RequiredArgsConstructor
@Controller
public class HomeController {
    private final EmpInfoRepository empInfoRepository;

    @GetMapping("/home")
    public String sixbeam_main(Model model) {
        return "contents/home/home_form";
    }
    @GetMapping("/profile")
    public String profile(Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Long empInfoId = Long.parseLong(username);
        Optional<EmpInfoEntity> empInfoEntityOptional = empInfoRepository.findByEmpInfoId(empInfoId);
        // Optional을 직접 사용
        model.addAttribute("empInfoOne", empInfoEntityOptional.orElseThrow(() -> new RuntimeException("사용자 정보를 찾을 수 없습니다.")));
        return "contents/home/profile_form";
    }
    @GetMapping("/check")
    public String check(Model model){
        return "contents/home/check_form";
    }
    @GetMapping("/attendmgt")
    public String attendmgt(Model model){
        return "contents/home/attendmgt_form";
    }
}
