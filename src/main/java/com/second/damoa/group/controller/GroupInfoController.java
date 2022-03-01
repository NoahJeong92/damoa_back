package com.second.damoa.group.controller;

import com.second.damoa.group.model.GroupInfo;
import com.second.damoa.group.model.UploadFile;
import com.second.damoa.group.repository.GroupInfoRepository;
import com.second.damoa.group.service.GroupImgStore;
import com.second.damoa.group.service.GroupInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    // 그룹 생성 로직 수행
    @PostMapping("/add")
    public String saveGroup(@ModelAttribute("groupInfo") GroupInfo groupInfo) throws Exception {
        groupInfoService.saveGroup(groupInfo);
        UploadFile attachImg = groupImgStore.storeImg(groupInfo.getGroupImg());

        log.info("groupImg= {}", groupInfo.getGroupImg());
        log.info("attachImg= {}", attachImg);
        return "redirect:/main.com";
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
