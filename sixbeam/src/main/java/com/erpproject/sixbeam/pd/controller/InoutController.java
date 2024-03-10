package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.hr.service.EmpInfoService;
import com.erpproject.sixbeam.pd.dto.InoutDto;
import com.erpproject.sixbeam.pd.entity.InoutEntity;
import com.erpproject.sixbeam.pd.repository.InoutRepository;
import com.erpproject.sixbeam.pd.service.InoutService;
import com.erpproject.sixbeam.pd.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/pd/inout")
@RequiredArgsConstructor
@Controller
public class InoutController {

    private final InoutRepository inoutRepository;
    private final InoutService inoutService;
    private final EmpInfoService empInfoService;
    private final ItemService itemService;

    @GetMapping("/inoutlist")
    public String list(Model model) {

        List<InoutEntity> inoutEntities = inoutService.getList();

        model.addAttribute("inoutEntities", inoutEntities);

        return "contents/pd/inout_list";
    }

    /*@GetMapping("/detail/{inoutCmptCd}")
    public ResponseEntity<List<InoutEntity>> detail(@PathVariable("inoutCmptCd") String inoutCmptCd) {

        String inoutlist = inoutService.getIdList(inoutCmptCd);
        String empInfo

        InoutDto inoutDto = new InoutDto();
        inoutDto.setEmpInfoEntity(empInfo);
        inoutDto.setItemEntity(itemInfo);

        if (!inoutEntities.isEmpty()) {

            return ResponseEntity.ok().body(inoutEntities);

        } else {

            return ResponseEntity.notFound().build();
        }
    }*/
}