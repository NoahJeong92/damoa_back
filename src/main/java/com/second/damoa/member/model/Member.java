package com.second.damoa.member.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "member")
public class Member {

    @Id
    private String memberId;

    private String pwd;

    private String name;

    private String age;

    public Member() {
    }

    public Member(String memberId, String pwd, String name, String age) {
        this.memberId = memberId;
        this.pwd = pwd;
        this.name = name;
        this.age = age;
    }
}
