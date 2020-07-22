package com.quan.api.service;

import com.quan.api.entity.PicUploadResult;
import com.quan.api.utils.QiniuUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class PicUploadService {
    //后端校验
    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg", ".jpeg", ".gif", ".png"};
    private static final String IMAGE_URL = "http://qdvmpgr05.bkt.clouddn.com/";
    public PicUploadResult upload(MultipartFile uploadFile) {
        boolean isLegal = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(uploadFile.getOriginalFilename(), type)) {
                isLegal = true;
                break;
            }
        }
        PicUploadResult fileUploadResult = new PicUploadResult();
        if(!isLegal){
            fileUploadResult.setStatus("error");
            return fileUploadResult;
        }
        //start to upload
        String originalFilename = uploadFile.getOriginalFilename();
        int lastIndexOf = originalFilename.lastIndexOf(".");
        String suffix =  originalFilename.substring(lastIndexOf);
        String fileName = UUID.randomUUID().toString() + suffix;
        try{
            QiniuUtils.upload2Qiniu(uploadFile.getBytes(),fileName);
        } catch (Exception e){
            fileUploadResult.setStatus("error");
            return fileUploadResult;
        }
        fileUploadResult.setStatus("done");
        fileUploadResult.setName(IMAGE_URL+fileName);
        fileUploadResult.setUid(String.valueOf(System.currentTimeMillis()));
        return fileUploadResult;
    }
}

