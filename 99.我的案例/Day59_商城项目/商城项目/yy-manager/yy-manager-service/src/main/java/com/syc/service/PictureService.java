package com.syc.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * 实现图片上传的接口
 * @类名称:PictureService
 * @创建人:一一哥
 * @创建时间:2017年11月10日 下午2:09:08
 */
public interface PictureService {

	public Map<String,Object> picUpload(MultipartFile uploadFile);
}
