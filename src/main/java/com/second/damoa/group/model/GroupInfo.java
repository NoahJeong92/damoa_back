package com.second.damoa.group.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import com.second.damoa.social.model.User;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int likecount;

    @NonNull
    @Enumerated(EnumType.STRING)
    private GroupType type;

    private String local;

    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int count;

    private String memberId;

//    //가입한 사람 목록
//    @OneToMany(mappedBy = "groupInfo")
//    List<User> User = new ArrayList<>();

    public GroupInfo() {
    }

}
