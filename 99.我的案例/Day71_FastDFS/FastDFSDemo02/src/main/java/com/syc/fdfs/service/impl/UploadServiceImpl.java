package com.syc.fdfs.service.impl;

import org.springframework.stereotype.Service;

import com.syc.fdfs.service.UploadService;
import com.syc.fdfs.util.FastDFSUtils;

@Service
public class UploadServiceImpl implements UploadService {

	 //上传图片
    public String uploadPic(byte[] pic ,String name,long size){
        return FastDFSUtils.uploadPic(pic, name, size);
    }
}
