package com.second.damoa;

import com.second.damoa.member.model.Member;
import org.junit.jupiter.api.Test;


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
}
