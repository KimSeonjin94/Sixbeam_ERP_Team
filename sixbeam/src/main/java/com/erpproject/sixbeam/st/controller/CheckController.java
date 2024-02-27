package com.erpproject.sixbeam.st.controller;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.service.CheckService;
import com.erpproject.sixbeam.st.entity.CheckEntity;
import com.erpproject.sixbeam.st.service.WhregistService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/st/check")
public class CheckController {

    private final CheckService checkService;
    private final WhregistService whregistService;

    @GetMapping("/")
    public String root() {
        return "redirect:/sixbeam/home";
    }

    //창고,품목별 값 조회---------------------------------------------------------------------------------------
    @GetMapping("/checkwhitemincoming")
    @ResponseBody
    public int getWhItemIncoming(@RequestParam("date") LocalDate date, WhregistEntity whregistEntity, ItemEntity itemEntity) {
        return checkService.getWhItemIncoming(date, whregistEntity, itemEntity);
    }

    @GetMapping("/checkwhitemoutcoming")
    @ResponseBody
    public int getWhItemOutcoming(@RequestParam("date") LocalDate date, WhregistEntity whregistEntity, ItemEntity itemEntity) {
        return checkService.getWhItemOutgoing(date, whregistEntity, itemEntity);
    }

    @GetMapping("/checkwhitemtotal")
    @ResponseBody
    public int getTotalWhItemCheckAmt(@RequestParam("date") LocalDate date, WhregistEntity whregistEntity, ItemEntity itemEntity) {
        return checkService.getTotalWhItemCheckAmt(date, whregistEntity, itemEntity);
    }

    //날짜로만 창고,품목의 수량 리스트 조회-------------------------------------------------------------------------------
    @GetMapping("/whitemlist")
    public String getAllWhItemCheckList() {
        return "contents/st/check_form";
    }

    @PostMapping("/whitemlist")
    public String handleWhitemlistForm(@RequestParam("date") LocalDate date, Model model) {
        List<Map<String, Object>> checkList = checkService.getAllWhItemCheckList(date);
        model.addAttribute("checkEntityList", checkList);
        return "contents/st/check_list";
    }
    //날짜 및 창고로 품목의 수량 리스트 조회-------------------------------------------------------------------------------
    @GetMapping("/whlist")
    public String getAllWhCheckList(Model model) {
        List<WhregistEntity> whregistEntity = this.whregistService.getList();
        model.addAttribute("getwhregistlist", whregistEntity);
        return "contents/st/check_form_wh";
    }
    @PostMapping("/whlist")
    public String handleWhlistForm(@RequestParam("date") LocalDate date, @RequestParam("whregistEntity.whregistCd") String whregistCd, Model model) {
        List<Map<String, Object>> checkList = checkService.getAllWhCheckList(date, whregistCd);
        List<WhregistEntity> whregistEntity = this.whregistService.getList();

        model.addAttribute("checkEntityList", checkList);
        return "contents/st/check_list";
    }

}






