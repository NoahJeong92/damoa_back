package com.second.damoa.group.service;

import com.second.damoa.group.dto.JoinUserDTO;
import com.second.damoa.group.model.GroupInfo;
import com.second.damoa.group.model.UserJoinGroup;
import com.second.damoa.group.repository.GroupInfoRepository;
import com.second.damoa.group.repository.JoinUserInterface;
import com.second.damoa.group.repository.UserJoinGroupRepository;
import com.second.damoa.social.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupInfoServiceImpl implements GroupInfoService {

    private final GroupInfoRepository groupInfoRepository;
    private final UserJoinGroupRepository userJoinGroupRepository;

    // 그룹 목록 조회
    @Override
    public List<GroupInfo> list() throws Exception {
        List<GroupInfo> groupInfoList = groupInfoRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
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
        return groupWrapper.get();
    }

    // 그룹에 가입한 유저 조회
    @Override
    public List<JoinUserInterface> joinList(Long id) throws Exception {
        List<JoinUserInterface> res = groupInfoRepository.joinUser(id);
        return res;
    }

    // 사용자 그룹 가입
    @Override
    public int joinGroup(Long id, String name) throws Exception {
        return groupInfoRepository.joinGroup(id, name);
    }

    // 그룹 이미지 변경
    @Override
    public int imgUpdate(Long id, String groupImg) throws Exception {
        return groupInfoRepository.imgUpdateQuery(id, groupImg);
    }

//    // 그룹 상세 정보 수정
//    @Override
//    public Long updateGroup(GroupInfo groupInfo) throws Exception {
//        GroupInfo newGroupInfo = groupInfoRepository.save(groupInfo);
//        return newGroupInfo.getId();
//    }
//
//    // 그룹 삭제
//    @Override
//    public Long deleteGroup(GroupInfo groupInfo) throws Exception {
//        groupInfoRepository.delete(groupInfo);
//        return null;
//    }
//
//    // 그룹 검색
//    @Override
//    public List<GroupInfo> searchTitle(String search) throws Exception {
//        List<GroupInfo> groupInfoList = groupInfoRepository.findByTitleContaining(search);
//        return groupInfoList;
//    }
//
//    // 조회수 카운트
//    @Override
//    public int updateCount(Long id) {
//        return groupInfoRepository.updateCount(id);
//    }
}
