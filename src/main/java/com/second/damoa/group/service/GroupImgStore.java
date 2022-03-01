package com.second.damoa.group.service;

import com.second.damoa.group.model.GroupInfo;
import com.second.damoa.group.model.UploadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class GroupImgStore {

    @Value("${file.dir}")
    private String fileDir;

    public String getFullPath(String filename) {
        return fileDir + filename;
    }

    // 업로드 이미지 저장
    public UploadFile storeImg(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }

        String originalImgName = multipartFile.getOriginalFilename();
        String storeImgName = createStoreImgName(originalImgName);
        multipartFile.transferTo(new File(getFullPath(storeImgName)));
        return new UploadFile(originalImgName, storeImgName);
    }

    // 업로드 이미지 이름 랜덤 생성
    private String createStoreImgName(String originalImgName) {
        String ext = extractExt(originalImgName);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    // 업로드 된 이미지 확장자명 유지
    private String extractExt(String originalImgName) {
        int pos = originalImgName.lastIndexOf(".");
        return originalImgName.substring(pos + 1);
    }
}
