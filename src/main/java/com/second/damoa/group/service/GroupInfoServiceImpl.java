package com.second.damoa.group.service;

import com.second.damoa.group.model.GroupInfo;
import com.second.damoa.group.repository.GroupInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupInfoServiceImpl implements GroupInfoService {

    private final GroupInfoRepository groupInfoRepository;

    @Override
    public List<GroupInfo> list() throws Exception {
        List<GroupInfo> groupInfoList = groupInfoRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        return groupInfoList;
    }

    @Override
    public Long saveGroup(GroupInfo groupInfo) throws Exception {
        GroupInfo result = groupInfoRepository.save(groupInfo);
        return result.getId();
    }

    @Override
    public GroupInfo readGroup(Long id) throws Exception {
        Optional<GroupInfo> groupWrapper = groupInfoRepository.findById(id);
        GroupInfo groupInfo = groupWrapper.get();
        return groupInfo;
    }
}
