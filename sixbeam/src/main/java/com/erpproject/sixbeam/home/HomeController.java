package com.erpproject.sixbeam.home;

import com.erpproject.sixbeam.pd.service.OrderService;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.service.OrinPutService;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.service.EstimateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/sixbeam")
@RequiredArgsConstructor
@Controller
public class HomeController {
    private final EstimateService estimateService;
    private final OrinPutService orinPutService;
//    private final OrderService orderService;

    @GetMapping("/home")
    public String sixbeam_main(Model model) {
        List<EstimateEntity> estimateEntities =estimateService.getList();
        List<OrinPutEntity> orinPutEntities=orinPutService.getList();
//        orderService.getList();
        model.addAttribute("estimateEntities",estimateEntities);
        model.addAttribute("orinPutEntities",orinPutEntities);
        return "contents/home/Home_Form";
    }
}
