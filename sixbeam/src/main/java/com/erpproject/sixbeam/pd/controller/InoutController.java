package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.pd.entity.InoutEntity;
import com.erpproject.sixbeam.pd.entity.OrderEntity;
import com.erpproject.sixbeam.pd.repository.InoutRepository;
import com.erpproject.sixbeam.pd.service.InoutService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.PrivateKey;
import java.util.List;

@RequestMapping("/pd/inout")
@Controller
@RequiredArgsConstructor
public class InoutController {

    private final InoutService inoutService;

    @GetMapping("/inoutlist")
    public String list(Model model) {

        // 서비스를 통해 모든 품목을 가져옴
        List<InoutEntity> inoutEntities = inoutService.getList();

        // 가져온 품목 리스트를 모델에 담음
        model.addAttribute("inoutEntities", inoutEntities);

        // 완품 리스트 뷰페이지 반환
        return "contents/pd/inout_list";
    }
}
