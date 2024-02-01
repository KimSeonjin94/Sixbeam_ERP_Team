package com.erpproject.sixbeam.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sixbeam")
@Controller
public class HomeController {
    @GetMapping("/home")
    public String sixbeam_main() {

        return "Contents/Home/Home_Form";
    }
}
