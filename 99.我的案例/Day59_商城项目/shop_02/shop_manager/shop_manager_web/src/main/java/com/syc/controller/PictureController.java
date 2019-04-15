package com.syc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.syc.common.utils.JsonUtils;
import com.syc.service.PictureService;

//@Controller--->指明该类是控制器组件
/*
 * 图片上传控制器
 */
@Controller
public class PictureController {

	@Autowired
	private PictureService service;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String uploadPic(MultipartFile uploadFile){
		//文件上传
		Map<String, Object> map = service.picUpload(uploadFile);
		//为了处理浏览器兼容问题，需要返回json字符串
		String json = JsonUtils.objectToJson(map);
		System.out.println("json="+json);
		return json;
	}
}
