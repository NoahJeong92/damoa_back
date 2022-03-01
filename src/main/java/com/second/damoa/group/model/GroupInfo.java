package com.second.damoa.group.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

import java.util.Date;

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

    @ColumnDefault("0")
    private int likecount;

    @NonNull
    private String type;

    private String local;

//    @Basic(optional = false)
    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @ColumnDefault("0")
    private int count;

    @NonNull
    private String memberId;

    public GroupInfo() {
    }

}
