package com.second.damoa;

import com.second.damoa.group.model.GroupInfo;
import com.second.damoa.member.model.Member;
import org.junit.jupiter.api.Test;

import java.security.acl.Group;


public class LombokTest {

    @Test
    public void testGetter() {
        Member member = new Member();

        System.out.println(member.getName());
    }

    @Test
    public void testSetter() {
        Member member = new Member();
        member.setName("테스트");

        System.out.println(member.getName());
    }

    @Test
    public void testSetterGroupInfo() {
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setGroupNo(1);
        groupInfo.setTitle("테스트입니다");

        System.out.println(groupInfo.getGroupNo());
        System.out.println(groupInfo.getTitle());

    }
}
