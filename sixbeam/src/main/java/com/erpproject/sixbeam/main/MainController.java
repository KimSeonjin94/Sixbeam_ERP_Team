package com.erpproject.sixbeam.main;


import com.erpproject.sixbeam.hr.service.EmpInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final EmpInfoService empInfoService;
    @GetMapping("/sixbeam")
    public String login() {
        return "contents/home/login_form";
    }
}
