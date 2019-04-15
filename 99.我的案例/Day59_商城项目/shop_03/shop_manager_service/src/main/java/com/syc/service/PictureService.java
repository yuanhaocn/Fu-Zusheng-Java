package com.syc.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/*
 * 图片上传接口
 */
public interface PictureService {

	Map<String,Object> picUpload(MultipartFile uploadFile);
}
