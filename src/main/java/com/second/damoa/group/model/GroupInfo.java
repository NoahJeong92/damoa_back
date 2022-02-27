package com.second.damoa.group.model;

import com.second.damoa.member.model.Member;
import lombok.*;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor // @NonNull 생성자
@Table(name = "groupinfo") // db 테이블명
public class GroupInfo {

    @Id
    @Column(name = "group_no") // db 컬럼명
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    private String memberId;

    public GroupInfo() {
    }

    public GroupInfo(Long id, @NonNull String title, @NonNull String content, String groupImg, @NonNull int likecount, @NonNull String type, String local, @NonNull Date createDate, @NonNull int count, String memberId) {
        this.id = id;
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
