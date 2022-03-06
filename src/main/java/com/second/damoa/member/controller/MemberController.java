package com.second.damoa.member.controller;

import com.second.damoa.member.model.Member;
import com.second.damoa.member.repository.MemberRepository;
import com.second.damoa.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    // 회원 목록 조회
    @GetMapping("/list")
    public String memberList(Model model) throws Exception{
        List<Member> membersList = memberService.list();
        model.addAttribute("membersList", membersList);
        return "member/memberList";
    }

    // 로그인 수행 로직
    @PostMapping("/login")
    public ModelAndView loginById(@ModelAttribute Member member, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        Member memberInfo = memberService.login(member);
        if (member != null) {
            HttpSession session = request.getSession();
            session.setAttribute("memberInfo", memberInfo);
            session.setAttribute("isLogOn", true);
            mav.setViewName("redirect:/main.com");
        } else {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>"
                    + "alert('입력한 정보가 올바르지 않습니다.');"
                    + "location.href='/member/login';"
                    + "</script>");
            out.flush();
        }
        return mav;
    }

    @PostMapping("/signup.do")
    public String memberSign(Member member, Model model) throws Exception {
        log.info("memberId={}", member.getMemberId());
        log.info("pwd={}", member.getPwd());
        log.info("name={}", member.getName());
        log.info("age={}", member.getAge());

        model.addAttribute(member.getMemberId());
        model.addAttribute(member.getPwd());
        model.addAttribute(member.getName());
        model.addAttribute(member.getAge());

        return "redirect:/";
    }

    /**
     * 테스트용 데이터 추가
     */
/*    @PostConstruct
    public void init() {
        memberRepository.save(new MemberModel("master123","master123","관리자","master123@damoa.com","true"));
        memberRepository.save(new MemberModel("test123","test123","테스트","test123@test.com","false"));
    }*/
}
