package com.second.damoa.group.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.second.damoa.group.dto.GroupInfoDTO;
import com.second.damoa.group.dto.JoinUserDTO;
import com.second.damoa.group.model.GroupInfo;
import com.second.damoa.group.repository.GroupInfoRepository;
import com.second.damoa.group.repository.JoinUserInterface;
import com.second.damoa.group.service.GroupImgStore;
import com.second.damoa.group.service.GroupInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RestController
@RequestMapping("/oauth2/redirect/groupinfo")
@RequiredArgsConstructor
public class GroupInfoController {

    // 업로드 이미지 저장 경로
    @Value("${file.dir}")
    private String fileDir;

    private final GroupInfoService groupInfoService;
    private final GroupImgStore groupImgStore;

    // 그룹 목록 조회 페이지 이동
    @GetMapping("/list")
    public List<GroupInfo> groupList() throws Exception {
        List<GroupInfo> groupInfo = groupInfoService.list();
        return groupInfo;
    }

    // 입력한 그룹 정보 저장
    @PostMapping("/add")
    public void saveGroup(@ModelAttribute GroupInfo groupInfo, @RequestParam("uploadImg") MultipartFile uploadImg,
                      HttpServletResponse response) throws Exception {
        String groupImg = groupImgStore.storeImg(uploadImg); // 업로드 이미지 파일 이름 랜덤 변경
        groupInfo.setGroupImg(groupImg);

        groupInfoService.saveGroup(groupInfo);
        response.sendRedirect("http://localhost:3000/");
    }

    // 그룹 정보 조회
    @GetMapping("/read/{id}")
    public GroupInfo groupRead(@PathVariable Long id) throws Exception {
        GroupInfo groupInfo = groupInfoService.readGroup(id);
        // groupInfoService.updateCount(id); // 조회수 업데이트
        return groupInfo;
    }

    // 그룹 대표 이미지 경로
    @GetMapping("/image/{filename}")
    public Resource groupImg(@PathVariable String filename) throws MalformedURLException {
        return new UrlResource("file:" + groupImgStore.getFullPath(filename));
    }

    // 그룹 정보 수정
    @PostMapping("/update")
    public String updateGroup(@ModelAttribute GroupInfo groupInfo,
                              @RequestParam("uploadImg") MultipartFile uploadImg) throws Exception {
        String groupImg = groupImgStore.storeImg(uploadImg);
        groupInfo.setGroupImg(groupImg);

        groupInfoService.updateGroup(groupInfo);
        return "redirect:http://localhost:3000/";
    }

    // 그룹 삭제
    @GetMapping("/delete/{id}")
    public void groupDelete(@PathVariable Long id, @RequestParam GroupInfo groupInfo) throws Exception {
        groupInfoService.deleteGroup(groupInfo);

    }

    // 그룹 title 검색
    @GetMapping("/search")
    public List<GroupInfo> search(@RequestParam String search) throws Exception {
        List<GroupInfo> searchGroup = groupInfoService.searchTitle(search);
        return searchGroup;
    }

    // 그룹 가입
    @PostMapping("/join/{id}")
    public void joinGroup(@PathVariable Long id,
                          @RequestParam(required = false) String name) throws Exception {
        groupInfoService.joinGroup(id, name);
    }

    // 그룹에 가입한 회원 조회
    @GetMapping("/join/user/{id}")
    public List<JoinUserInterface> joinUser(@PathVariable Long id) throws Exception {
        List<JoinUserInterface> joinUser = groupInfoService.joinList(id);
        return joinUser;
    }
}
