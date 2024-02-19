package com.erpproject.sixbeam.st.controller;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.service.AccountService;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.service.ItemService;
import com.erpproject.sixbeam.st.dto.AsDto;
import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.form.AsForm;
import com.erpproject.sixbeam.st.service.AsService;
import com.erpproject.sixbeam.st.service.WhmoveService;
import com.erpproject.sixbeam.st.service.WhregistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/st/as")
public class AsController {

    private final AsService asService;
    private final AccountService accountService;
    private final EmpInfoService empInfoService;
    private final WhregistService whregistService;
    private final ItemService itemService;

    @GetMapping("/")
    public String root() {
        return "redirect:/sixbeam/home";
    }
    @GetMapping("/list")
    public String list(Model model) {
        List<AsEntity> asEntityList = this.asService.getList();
        model.addAttribute("asEntityList",asEntityList);
        return "contents/st/as_list";
    }
    @GetMapping(value = "/detail/{asCd}")
    public String detail(Model model, @PathVariable("asCd") String asCd) {
        AsEntity asEntity = this.asService.getAsEntity(asCd);
        model.addAttribute("asEntity",asEntity);
        return "contents/st/as_detail";
    }
    //AS등록_페이지
    @GetMapping("/create")
    public String asCreate(Model model){
        AsForm form = new AsForm();
        List<AccountEntity> accountEntity = this.accountService.getList();
        List<EmpInfoEntity> empInfoEntity = this.empInfoService.getList();
        List<ItemEntity> itemEntitiy = this.itemService.getList();
        List<WhregistEntity> whregistEntity = this.whregistService.getList();
        form.getAsDtos().add(new AsDto());
        form.getAsDtos().add(new AsDto());
        model.addAttribute("getactlist",accountEntity);
        model.addAttribute("getemplist",empInfoEntity);
        model.addAttribute("getitemlist",itemEntitiy);
        model.addAttribute("getwhregistlist", whregistEntity);
        model.addAttribute("asForm",form);
        return "contents/st/as_form";
    }
}
