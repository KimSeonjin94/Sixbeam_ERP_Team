package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.dto.ReceivablesDto;
import com.erpproject.sixbeam.ac.entity.ReceivablesEntity;
import com.erpproject.sixbeam.ac.service.ReceivablesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/ac")
@RestController
public class ReceivablesController {

    private final ReceivablesService receivablesService;

//    @GetMapping("/receivables/receivables")
//    public ResponseEntity<List<ReceivablesEntity>> searchReceivables(
//            @RequestParam(required = false) String accountCd,
//            @RequestParam(required = false) String accountNm) {
//
//        if (accountCd == null && accountNm == null) {
//            return ResponseEntity.badRequest().build();
//        }
//
//        List<ReceivablesEntity> receiv = receivablesService.searchReceivables(
//                accountCd != null ? accountCd : "",
//                accountNm != null ? accountNm : ""
//        );
//
//        return ResponseEntity.ok(receiv);
//    }

}
