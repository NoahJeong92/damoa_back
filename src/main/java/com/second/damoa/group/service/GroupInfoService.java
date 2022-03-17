package com.second.damoa.group.service;

import com.second.damoa.group.dto.JoinUserDTO;
import com.second.damoa.group.model.GroupInfo;
import com.second.damoa.group.repository.JoinUserInterface;

import java.util.List;

public interface GroupInfoService {
    public List<GroupInfo> list() throws Exception; // 그룹 목록 조회
    public Long saveGroup(GroupInfo groupInfo) throws Exception; // 그룹 생성
    public GroupInfo readGroup(Long id) throws Exception; // 그룹 상세 정보 조회
    public Long updateGroup(GroupInfo groupInfo) throws Exception; // 그룹 정보 수정
    public Long deleteGroup(GroupInfo groupInfo) throws Exception; // 그룹 삭제
    public List<GroupInfo> searchTitle(String search) throws Exception; // 그룹 검색
    public int updateCount(Long id); // 조회수 업데이트
    public List<JoinUserInterface> joinList(Long id) throws Exception; // 그룹에 가입한 회원 조회
    public int joinGroup(Long id, String name) throws Exception;

}
