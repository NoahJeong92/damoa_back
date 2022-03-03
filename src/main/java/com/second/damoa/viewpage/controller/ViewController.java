package com.second.damoa.viewpage.controller;

import com.second.damoa.group.model.GroupInfo;
import com.second.damoa.group.repository.GroupInfoRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
public class ViewController {

    // 메인 페이지 뷰
    @RequestMapping("/main.com")
    public ModelAndView mainPage() {
        String viewName = "index";
        ModelAndView mav = new ModelAndView(viewName);
        return mav;
    }

    // 로그인 페이지 뷰
    @RequestMapping("/loginForm")
    public ModelAndView loginPage() {
        String viewName = "member/loginForm";
        ModelAndView mav = new ModelAndView(viewName);
        return mav;
    }
}
