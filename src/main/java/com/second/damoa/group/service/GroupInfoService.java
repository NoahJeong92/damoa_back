package com.second.damoa.group.service;

import com.second.damoa.group.model.GroupInfo;

import java.util.List;

public interface GroupInfoService {
    public List<GroupInfo> list() throws Exception;
    public Long saveGroup(GroupInfo groupInfo) throws Exception;
}
