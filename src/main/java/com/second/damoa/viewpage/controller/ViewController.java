package com.second.damoa.viewpage.controller;

import com.second.damoa.group.model.GroupInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    // 그룹 생성 페이지 이동
    @GetMapping("/groupinfo/groupInfoWrite")
    public String groupAdd() {
        return "group/groupInfoWrite";
    }
}
