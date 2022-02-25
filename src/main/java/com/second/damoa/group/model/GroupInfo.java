package com.second.damoa.group.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.sql.Blob;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class GroupInfo {

    @Id
    private int GroupNo;

    private String title;

    @Lob
    private String content;

    @Lob
    private String groupImg;

    private String likecount;

    private String type;

    private String local;

    private String createDate;

    private int count;

    private String memberId;

}
