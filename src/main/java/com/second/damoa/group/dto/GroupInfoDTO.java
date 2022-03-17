package com.second.damoa.group.dto;

import lombok.Data;

@Data
public class GroupInfoDTO {
    private Long id;
    private String title;
    private String content;

    public GroupInfoDTO() {
    }

    public GroupInfoDTO(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
