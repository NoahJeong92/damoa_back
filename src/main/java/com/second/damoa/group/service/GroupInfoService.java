package com.second.damoa.group.service;

import com.second.damoa.group.model.GroupInfo;
import com.second.damoa.group.model.UserJoinGroup;
import com.second.damoa.group.repository.JoinUserInterface;

import java.util.List;

public interface GroupInfoService {
    List<GroupInfo> list() throws Exception; // 그룹 목록 조회
    Long saveGroup(GroupInfo groupInfo) throws Exception; // 그룹 생성
    GroupInfo readGroup(Long id) throws Exception; // 그룹 상세 정보 조회
    List<JoinUserInterface> joinList(Long id) throws Exception; // 그룹에 가입한 회원 조회
    int joinGroup(Long id, String name) throws Exception; // 그룹 가입
    int imgUpdate(Long id, String groupImg) throws Exception; // 그룹 이미지 변경

//    Long updateGroup(GroupInfo groupInfo) throws Exception; // 그룹 정보 수정
//    Long deleteGroup(GroupInfo groupInfo) throws Exception; // 그룹 삭제
//    List<GroupInfo> searchTitle(String search) throws Exception; // 그룹 검색
//    int updateCount(Long id); // 조회수 업데이트

}
