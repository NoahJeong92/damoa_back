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

import java.util.List;

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
    public String loginById(@ModelAttribute Member member) {
        String email = member.getEmail();
        String pwd = member.getPwd();
        log.info("email={}, pwd={}", email, pwd);
        return "redirect:/main.com";
    }

    // 로그인 페이지 뷰
    @RequestMapping("/loginForm")
    public ModelAndView loginPage() {
        String viewName = "member/loginForm";
        ModelAndView mav = new ModelAndView(viewName);
        return mav;
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
