package com.second.damoa.group.controller;

import com.second.damoa.group.model.GroupInfo;
import com.second.damoa.group.repository.GroupInfoRepository;
import com.second.damoa.group.service.GroupInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/groupinfo")
@RequiredArgsConstructor
public class GroupInfoController {

    private final GroupInfoService groupInfoService;
    private final GroupInfoRepository groupInfoRepository;

    // 그룹 조회
    @GetMapping("/list")
    public String groupList(Model model) throws Exception {
        List<GroupInfo> groupInfo = groupInfoService.list();
        model.addAttribute("groupInfo", groupInfo);
        return "group/groupInfoList";
    }

    // 그룹 생성
    @PostMapping("/add")
    public String groupAdd() {
        return "add";
    }

    // 그룹 수정
    @PostMapping("/update")
    public String groupUpdate() {
        return "update";
    }

    // 그룹 삭제
    @PostMapping("/delete")
    public String groupDelete() {
        return "delete";
    }

    // 그룹 검색
    @GetMapping("/search")
    public String search() {
        return "search";
    }
}
