package com.second.damoa.member.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Member {

    @Id
    private String memberId;

    private String pwd;

    private String name;

    private String email;

    private String role;

}
