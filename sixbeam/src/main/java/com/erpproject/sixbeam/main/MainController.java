package com.erpproject.sixbeam.main;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MainController {

    @GetMapping("/sixbeam")
    public String login() {
        return "contents/home/Login_Form";
    }

}
