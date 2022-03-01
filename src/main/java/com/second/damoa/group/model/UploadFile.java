package com.second.damoa.group.model;

import lombok.Data;

@Data
public class UploadFile {

    private String uploadImgName;
    private String storeImgName;

    public UploadFile(String uploadImgName, String storeImgName) {
        this.uploadImgName = uploadImgName;
        this.storeImgName = storeImgName;
    }
}
