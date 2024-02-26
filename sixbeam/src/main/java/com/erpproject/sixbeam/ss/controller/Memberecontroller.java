package com.erpproject.sixbeam.ss.controller;

import com.erpproject.sixbeam.ss.dto.MemberDto;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.MemberEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.ss.repository.EstimateRepository;
import com.erpproject.sixbeam.ss.repository.MemberRepository;
import com.erpproject.sixbeam.ss.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.spi.ManagedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequiredArgsConstructor
@RequestMapping("/ss/member")
@Controller
public class Memberecontroller {

    private final MemberService memberService;

    private final EstimateRepository estimateRepository;

    @GetMapping("/new")
    public String newMemberDto(Model model){
        MemberDto memberDto = new MemberDto();
        List<EstimateEntity> estimateEntities = memberService.getEstimateList();
        for(EstimateEntity estimateEntity : estimateEntities){
            System.out.println(estimateEntity);
        }
        model.addAttribute("memberDto",memberDto);
        model.addAttribute("estimateEntities",estimateEntities);
        return "contents/ss/member_form";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<EstimateEntity> estimateEntities = memberService.getEstimateList();
        List<MemberEntity> memberEntities = memberService.getMemberList();
        model.addAttribute("estimateEntities",estimateEntities);
        model.addAttribute("memberEntities",memberEntities);
        return "contents/ss/member_list";
    }
    @PostMapping("create")
    public ResponseEntity<?>  create(@Validated @ModelAttribute MemberDto memberDto){
        try {
            this.memberService.create(memberDto);
            return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl", "/ss/member/list"));
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "저장에 실패 하였습니다.");
            errorResponse.put("redirectUrl", "/ss/member/new");
            return ResponseEntity.badRequest().body(errorResponse);
        }

    }

    @GetMapping(value = "/list/detail/{id}")
    public ResponseEntity<Map<String, Object>> detail(Model model, @PathVariable("id") String id){
        Optional<MemberEntity> optionalMemberEntity =memberService.getMemberEntity(id);
        if (optionalMemberEntity.isPresent()) {
            MemberEntity memberEntity =optionalMemberEntity.get();
            Map<String, Object> response = new HashMap<>();
            response.put("memberEntity",memberEntity);


            return ResponseEntity.ok(response);
        } else {
            // 존재하지 않는 경우 적절한 예외 처리나 오류 응답
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "결과 없음");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

}
