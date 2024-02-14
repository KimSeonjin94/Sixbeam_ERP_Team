package com.erpproject.sixbeam.st.controller;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.service.CheckService;
import com.erpproject.sixbeam.st.entity.CheckEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/st/check")
public class CheckController {

    private final CheckService checkService;

    @GetMapping("/")
    public String root() {
        return "redirect:/sixbeam/home";
    }

    //전체 조회---------------------------------------------------------------------------------------
    @GetMapping("/checktotal")
    @ResponseBody
    public int getTotalCheckAmt(@RequestParam("date") LocalDate date) {
        return checkService.getTotalCheckAmt(date);
    }

    @GetMapping("/checkoutgoing")
    @ResponseBody
    public int getTotalOutgoing(@RequestParam("date") LocalDate date) {
        return checkService.getTotalOutgoing(date);
    }

    @GetMapping("/checkincoming")
    @ResponseBody
    public int getTotalIncoming(@RequestParam("date") LocalDate date) {
        return checkService.getTotalIncoming(date);
    }

    //아이템별 조회---------------------------------------------------------------------------------------
    @GetMapping("/checkitemincoming")
    @ResponseBody
    public int getItemIncoming(@RequestParam("date") LocalDate date, ItemEntity itemEntity) {
        return checkService.getItemIncoming(date, itemEntity);
    }

    @GetMapping("/checkitemoutgoing")
    @ResponseBody
    public int getItemOutgoing(@RequestParam("date") LocalDate date, ItemEntity itemEntity) {
        return checkService.getItemOutgoing(date, itemEntity);
    }

    @GetMapping("/checkitemtotal")
    @ResponseBody
    public int getTotalItemCheckAmt(@RequestParam("date") LocalDate date, ItemEntity itemEntity) {
        return checkService.getTotalItemCheckAmt(date, itemEntity);
    }

    //창고별 조회---------------------------------------------------------------------------------------
    @GetMapping("/checkwhincoming")
    @ResponseBody
    public int getWhIncoming(@RequestParam("date") LocalDate date, WhregistEntity whregistEntity) {
        return checkService.getWhIncoming(date, whregistEntity);
    }

    @GetMapping("/checkwhoutcoming")
    @ResponseBody
    public int getWhOutcoming(@RequestParam("date") LocalDate date, WhregistEntity whregistEntity) {
        return checkService.getWhOutgoing(date, whregistEntity);
    }

    @GetMapping("/checkwhtotal")
    @ResponseBody
    public int getTotalWhCheckAmt(@RequestParam("date") LocalDate date, WhregistEntity whregistEntity) {
        return checkService.getTotalWhCheckAmt(date, whregistEntity);
    }

    //창고,품목별 조회---------------------------------------------------------------------------------------
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

/*
    // 특정 날짜를 기준으로 원하는 column들만 조회하는 엔드포인트
    @GetMapping("/byDate")
    public String getCheckByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, Model model) {
        List<Map<String, Object>> inventoryList = checkService.getCheckByDate(date);
        model.addAttribute("inventoryList", inventoryList);
        return "contents/st/check_list";
    }
*/
@GetMapping("/byDatetest")
public String getChecktest(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, Model model) {
    List<Map<String, Object>> inventoryList = checkService.getChecktest(date);
    model.addAttribute("inventoryList", inventoryList);
    return "contents/st/check_list";
    }
}

/*
    @GetMapping("/list")
    public String list(Model model) {
        List<CheckEntity> checkEntityList = this.checkService.getList();
        model.addAttribute("checkEntityList", checkEntityList);
        return "contents/st/check_list";
    }
*/




