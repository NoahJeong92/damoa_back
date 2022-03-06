package com.second.damoa.test.service;


import com.second.damoa.group.model.GroupInfo;
import com.second.damoa.test.model.Boardtest;

import java.util.List;

public interface TestFBoardService {
    public List<Boardtest> list() throws Exception; // 그룹 목록 조회
    public Long saveGroup(Boardtest boardtest) throws Exception; // 그룹 생성
    public Boardtest readList(Long id) throws Exception; // 그룹 상세 정보 조회
}
