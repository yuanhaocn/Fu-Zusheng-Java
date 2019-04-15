package com.syc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.syc.common.utils.JsonUtils;
import com.syc.service.PictureService;

/**
 * 负责图片上传
 * @类名称:PictureController
 * @创建人:一一哥
 * @创建时间:2017年11月10日 下午2:46:22
 */
@Controller
public class PictureController {

	@Autowired
	private PictureService picService;
	
	@ResponseBody
	@RequestMapping("/pic/upload")
	public String uploadPic(MultipartFile uploadFile){
		Map<String, Object> map = picService.picUpload(uploadFile);
		String json = JsonUtils.objectToJson(map);
		System.out.println("json="+json);
		return json;
	}
}
