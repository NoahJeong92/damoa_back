package com.second.damoa.member.service;

import com.second.damoa.group.model.GroupInfo;
import com.second.damoa.member.model.Member;
import com.second.damoa.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public List<Member> list() throws Exception {
        List<Member> membersList = memberRepository.findAll(Sort.by(Sort.Direction.DESC,"memberId"));
        return membersList;
    }

    @Override
    public Member login(Member member) throws Exception {
        Optional<Member> memberWrapper = memberRepository.findById(member.getMemberId());
        member = memberWrapper.get();
        return member;
    }
}
