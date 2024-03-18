package com.erpproject.sixbeam.home;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import com.erpproject.sixbeam.pd.service.OrderService;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.service.OrinPutService;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.service.EstimateService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RequestMapping("/sixbeam")
@RequiredArgsConstructor
@Controller
public class HomeController {
    private final EstimateService estimateService;
    private final OrinPutService orinPutService;
//    private final OrderService orderService;
    private final EmpInfoService empInfoService;
    private final EmpInfoRepository empInfoRepository;
    private final GrapeService grapeService;
    @GetMapping("/home")
    public String sixbeam_main(Model model) {
        List<EstimateEntity> estimateEntities =estimateService.getList();
        List<OrinPutEntity> orinPutEntities=orinPutService.getList();
        String url = "http://localhost:8000/sales-summary";
        String url2 = "http://localhost:8000/input-summary";
        GrapeForm saleGrapeForm = grapeService.getGrapePredictions(url);
        GrapeForm inputGrapeForm = grapeService.getGrapePredictions(url2);
        model.addAttribute("saleGrapeForm", saleGrapeForm);
        model.addAttribute("inputGrapeForm", inputGrapeForm);
//        orderService.getList();
        model.addAttribute("estimateEntities",estimateEntities);
        model.addAttribute("orinPutEntities",orinPutEntities);
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
