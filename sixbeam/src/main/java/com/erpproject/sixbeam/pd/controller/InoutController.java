package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.Form.OrderForm;
import com.erpproject.sixbeam.pd.dto.InoutDto;
import com.erpproject.sixbeam.pd.dto.OrderDto;
import com.erpproject.sixbeam.pd.entity.BomEntity;
import com.erpproject.sixbeam.pd.entity.InoutEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.OrderEntity;
import com.erpproject.sixbeam.pd.repository.InoutRepository;
import com.erpproject.sixbeam.pd.service.InoutService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/pd/inout")
@RequiredArgsConstructor
@Controller
public class InoutController {

    private final InoutService inoutService;

    @GetMapping("/inoutlist")
    public String list(Model model) {

        List<InoutEntity> inoutEntities = inoutService.getList();

        model.addAttribute("inoutEntities", inoutEntities);

        return "contents/pd/inout_list";
    }

    /*@GetMapping("/detail/{inoutCmptCd}")
    public ResponseEntity<List<InoutEntity>> detail(@PathVariable) {

        return "";
    }*/
}


