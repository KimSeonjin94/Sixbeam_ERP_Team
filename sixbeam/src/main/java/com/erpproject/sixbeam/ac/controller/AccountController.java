package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.dto.AccountDto;
import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/ac")
@Controller
public class AccountController {

    // 거래처 영역

    // 거래처 서비스 클라스의 함수 사용을 위한 import
    private final AccountService accountService;


    // 거래처 목록 메뉴
    // 등록된 거래처를 가져오는 메소드
    @GetMapping("/account/list")
    public String getAccountList(Model model) {
        // 레포지토리의 데이터를 서비스를 통해 리스트에 담는다.
        List<AccountEntity> accountList = this.accountService.getList();
        // 뷰템플릿에 쓰일 모델 객체에 리스트를 삽입
        model.addAttribute("accountList",accountList);
        // html 페이지를 보여준다.
        return "contents/ac/account_list";
    }

    // 거래처 목록에서 신규를 등록하는 메소드
    @PostMapping("/account/register")
    public String registerAccount(@ModelAttribute AccountDto accountDto) {
        // 모달창에 입력한 내용을 accountDto 담고 서비스를 통해 DB에 저장
        accountService.saveAccount(accountDto);
        // 갱신된 거래처 리스틀를 보여준다.
        return "redirect:list";
        // 갱신된 거래처 리스틀를 보여준다.
    }
    // 거래처 목록에서 기존의 데이터를 수정하는 메소드
    @PostMapping("/account/edit")
    public String editAccount(@ModelAttribute AccountDto accountDto) {
        // 모달창에 입력한 내용을 accountDto 담고 서비스를 통해 DB에 저장
        // 구조는 신규와 같다. 하지만 하이퍼텍스트를 눌렀을 때 기존의 내용이 미리 저장되어 있다.
        // 수정 후 그 내용을 다시 accountDto에 보내어 DB에 갱신된 값을 저장.
        accountService.updateAccount(accountDto);
        // 갱신된 거래처 리스트를 보여준다.
        return "redirect:list";
    }
    // 거래처 목록에서 기존의 데이터를 삭제하는 메소드
    @PostMapping("/account/delete")
    public String deleteAccount(@RequestParam(name = "accountCd") String accountCd) {
        // 체크 표시된 행의 id값(accountCd)을 가져와 DB에서 그에 해당하는 행을 검색.
        accountService.deleteAccount(accountCd);
        // 서비스의 함수를 통해 DB에 있는 검색된 행을 삭제
        return "redirect:list";
        // 갱신된 거래처 리스틀를 보여준다.
    }

    // 거래처 등록 메뉴
    @GetMapping("/account/registerform")
    public String getRegisterAccountForm(Model model) {
        // 거래처 등록 페이지를 보여준다.
        return "contents/ac/account_form";
    }
    @PostMapping("/account/registerform")
    public String registerAccountByPage(@ModelAttribute AccountDto accountDto) {
        // 거래처 등록 페이지에 입력된 값을 accountDto에 담아
        accountService.saveAccount(accountDto);
        // 서비스의 saveAccount를 통해 저장한다.
        return "redirect:registerform";
        // 데이터를 보낸 후 등록페이지를 다시 보여준다.
    }
}
