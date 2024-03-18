package com.erpproject.sixbeam.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/path/to/tab")
public class SidebarController {

    @GetMapping("/{tabId}/sidebar")
    public String loadSidebarContent(@PathVariable String tabId, Model model) {
        // 여기에서 필요한 로직 수행 및 모델에 데이터 추가
        return "fragments/sidebarContent :: " + tabId + "sidebarFragment";
    }

    @GetMapping("/{tabId}/content")
    public String loadTabContent(@PathVariable String tabId, Model model) {
        // 여기에서 필요한 로직 수행 및 모델에 데이터 추가
        return "fragments/content :: " + tabId + "contentFragment";
    }
}
