package com.second.damoa.viewpage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
