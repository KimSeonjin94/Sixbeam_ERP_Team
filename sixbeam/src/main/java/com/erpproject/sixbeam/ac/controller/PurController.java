package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.dto.AccountDto;
import com.erpproject.sixbeam.ac.dto.PurDto;
import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.entity.PurEntity;
import com.erpproject.sixbeam.ac.repository.PurRepository;
import com.erpproject.sixbeam.ac.service.AccountService;
import com.erpproject.sixbeam.ac.service.PurService;
import com.erpproject.sixbeam.pur.entity.InputEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/ac")
public class PurController {

    private final AccountService accountService;
    private final PurService purService;

    @GetMapping("/pur/purSlip")
    public String purSlipForm(Model model) {
        List<AccountEntity> actEntity = this.accountService.getList();
        List<InputEntity> inputEntities = this.purService.getInputList();
        model.addAttribute("actList", actEntity);
        model.addAttribute("inputEntities", inputEntities);
        return "contents/ac/pur_slip";
    }

    @PostMapping("/pur/purSlip")
    public ResponseEntity<?> savePurSlip(@ModelAttribute PurDto purDto) {
        Map<String, Object> Response = null;
        try {
            purService.savePurSLip(purDto);
            Response = new HashMap<>();
            Response.put("status", "success");
            Response.put("message", "정상적으로 저장되었습니다.");
            Response.put("redirectUrl", "/ac/pur/purSlip");  // 저장 후 목록 페이지로 리다이렉트
            return ResponseEntity.ok().body(Response);
        } catch (Exception e) {
            Response = new HashMap<>();
            Response.put("status", "error");
            Response.put("message", String.format("저장에 실패 하였습니다.[%s]", e.getMessage()));
            Response.put("redirectUrl", "/ac/pur/purSlip");
            return ResponseEntity.badRequest().body(Response);
        }
    }

}
