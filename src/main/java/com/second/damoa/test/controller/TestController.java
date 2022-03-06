package com.second.damoa.test.controller;

import com.second.damoa.test.model.Boardtest;
import com.second.damoa.test.service.TestFBoardService;
import com.sun.deploy.net.HttpResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestFBoardService testFBoardService;

    // 글 저장
    @PostMapping("/fboard")
    public void posttestFBoard(@ModelAttribute Boardtest boardtest, HttpServletResponse response) throws Exception{
        testFBoardService.saveGroup(boardtest);
        response.sendRedirect("http://localhost:3000/freepost/1");
    }

    // 글 목록 조회
    @GetMapping("/fboard/list")
    public List<Boardtest> gettestFBoard(Model model) throws Exception {
        List<Boardtest> membersList = testFBoardService.list();
//        membersList = testFBoardService.list();
        return membersList;
    }

    // 글 상세 조회
    @GetMapping("/fboard/list/{id}")
    public Boardtest detailFBoard(@PathVariable Long id, Model model) throws Exception {
        Boardtest detailfboard = testFBoardService.readList(id);
//        model.addAttribute("detailfboard", detailfboard);
        return detailfboard;
    }
}
