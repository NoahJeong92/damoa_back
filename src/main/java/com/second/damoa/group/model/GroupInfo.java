package com.second.damoa.group.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "groupinfo")
public class GroupInfo {

    @Id
    private Integer groupNo;

    @NonNull
    private String title;

    @Lob
    @NonNull
    private String content;

    @Lob
    private String groupImg;

    @NonNull
    private int likecount;

    @NonNull
    private String type;

    private String local;

    @NonNull
    private Date createDate;

    @NonNull
    private int count;

    @NonNull
    private String memberId;

    public GroupInfo() {
    }

    public GroupInfo(Integer groupNo, @NonNull String title, @NonNull String content, String groupImg, @NonNull int likecount, @NonNull String type, String local, @NonNull Date createDate, @NonNull int count, @NonNull String memberId) {
        this.groupNo = groupNo;
        this.title = title;
        this.content = content;
        this.groupImg = groupImg;
        this.likecount = likecount;
        this.type = type;
        this.local = local;
        this.createDate = createDate;
        this.count = count;
        this.memberId = memberId;
    }
}
