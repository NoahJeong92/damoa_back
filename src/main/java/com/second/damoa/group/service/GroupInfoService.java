package com.second.damoa.group.service;

import com.second.damoa.group.model.GroupInfo;

import java.util.List;
import java.util.Optional;

public interface GroupInfoService {
    public List<GroupInfo> list() throws Exception; // 그룹 목록 조회
    public Long saveGroup(GroupInfo groupInfo) throws Exception; // 그룹 생성
    public GroupInfo readGroup(Long id) throws Exception; // 그룹 정보 조회

}
