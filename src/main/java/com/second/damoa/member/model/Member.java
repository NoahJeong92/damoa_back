package com.second.damoa.member.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Member")
@Getter
@Setter
public class Member {

    @Id
    private String memberId;

    private String pwd;

    private String name;

    private String email;

    private String role;

    public Member() {
    }

    public Member(String memberId, String pwd, String name, String email, String role) {
        this.memberId = memberId;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.role = role;
    }
}
