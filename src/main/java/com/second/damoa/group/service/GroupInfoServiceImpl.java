package com.second.damoa.group.service;

import com.second.damoa.group.model.GroupInfo;
import com.second.damoa.group.repository.GroupInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.acl.Group;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupInfoServiceImpl implements GroupInfoService {

    private final GroupInfoRepository groupInfoRepository;

    // 그룹 목록 조회
    @Override
    public List<GroupInfo> list() throws Exception {
        List<GroupInfo> groupInfoList = groupInfoRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        return groupInfoList;
    }

    // 그룹 생성
    @Override
    public Long saveGroup(GroupInfo groupInfo) throws Exception {
        GroupInfo result = groupInfoRepository.save(groupInfo);
        return result.getId();
    }

    // 그룹 상세 정보 조회
    @Override
    public GroupInfo readGroup(Long id) throws Exception {
        Optional<GroupInfo> groupWrapper = groupInfoRepository.findById(id);
        GroupInfo groupInfo = groupWrapper.get();
        return groupInfo;
    }

    // 그룹 상세 정보 수정
    @Override
    public Long updateGroup(GroupInfo groupInfo) throws Exception {
        GroupInfo newGroupInfo = groupInfoRepository.save(groupInfo);
        return newGroupInfo.getId();
    }

    @Override
    public Long deleteGroup(GroupInfo groupInfo) throws Exception {
        groupInfoRepository.delete(groupInfo);
        return null;
    }
}
