package com.second.damoa.group.service;

import com.second.damoa.group.model.GroupInfo;
import com.second.damoa.group.repository.GroupInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupInfoServiceImpl implements GroupInfoService {

    private final GroupInfoRepository groupInfoRepository;

    @Override
    public List<GroupInfo> list() throws Exception {
        List<GroupInfo> groupInfoList = groupInfoRepository.findAll(Sort.by(Sort.Direction.DESC,"groupNo"));
        return groupInfoList;
    }
}
