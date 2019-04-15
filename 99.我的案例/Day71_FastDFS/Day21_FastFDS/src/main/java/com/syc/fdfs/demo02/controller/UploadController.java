package com.syc.fdfs.demo02.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.syc.fdfs.demo02.ImageConstant;
import com.syc.fdfs.demo02.service.UploadService;

@Controller
public class UploadController {

	@Autowired
	private UploadService service;

	// 单个文件上传
	@RequestMapping("/upload/uploadPic")
	public void uploadPic(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response) {
		try {
			String path = service.uploadFile(pic.getBytes(), pic.getOriginalFilename(), pic.getSize());
			String url = ImageConstant.IMG_SERVER + path;

			// 将Java对象转为json字符串
			ObjectMapper mapper = new ObjectMapper();
			String jsonUrl = mapper.writeValueAsString(url);

			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(jsonUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 多个文件上传
	@ResponseBody
	@RequestMapping("/upload/uploadPics")
	public List<String> uploadPics(@RequestParam(required = false) MultipartFile[] pics, HttpServletResponse response) {
		try {
			
			ArrayList<String> urls=new ArrayList<String>();
			for(MultipartFile pic : pics){
				String path = service.uploadFile(pic.getBytes(), pic.getOriginalFilename(), pic.getSize());
				String url = ImageConstant.IMG_SERVER + path;
				urls.add(url);
			}

			return urls;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
