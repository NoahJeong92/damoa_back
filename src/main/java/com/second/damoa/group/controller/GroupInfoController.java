package com.second.damoa.group.controller;

import com.second.damoa.group.model.GroupInfo;
import com.second.damoa.group.repository.GroupInfoRepository;
import com.second.damoa.group.service.GroupImgStore;
import com.second.damoa.group.service.GroupInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/groupinfo")
@RequiredArgsConstructor
public class GroupInfoController {

    // 업로드 이미지 저장 경로
    @Value("${file.dir}")
    private String fileDir;
    private final GroupInfoService groupInfoService;
    private final GroupImgStore groupImgStore;
    private final GroupInfoRepository groupInfoRepository;

    // 그룹 목록 조회 페이지 이동
    @GetMapping("/list")
    public String groupList(Model model) throws Exception {
        List<GroupInfo> groupInfo = groupInfoService.list();
        model.addAttribute("groupInfo", groupInfo);
        return "group/groupInfoList";
    }

    // 그룹 입력 정보 저장 로직
    @PostMapping("/add")
    public String saveGroup(@ModelAttribute GroupInfo groupInfo, @RequestParam("uploadImg") MultipartFile uploadImg) throws Exception {
        String groupImg = groupImgStore.storeImg(uploadImg);
        groupInfo.setGroupImg(groupImg);

        log.info("memberId= {}", groupInfo.getMemberId());
        log.info("groupImg= {}", groupInfo.getGroupImg());

        groupInfoService.saveGroup(groupInfo);

        return "redirect:/main.com";
    }

    // 그룹 정보 조회 페이지 이동
    @GetMapping("/read/{id}")
    public String groupRead(@PathVariable Long id, Model model) throws Exception {
        GroupInfo groupInfo = groupInfoService.readGroup(id);
        model.addAttribute("groupInfo", groupInfo);
        return "group/groupInfoRead";
    }

    // 그룹 대표 이미지 경로
    @ResponseBody
    @GetMapping("/image/{filename}")
    public Resource groupImg(@PathVariable String filename) throws MalformedURLException {
        return new UrlResource("file:" + groupImgStore.getFullPath(filename));
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
