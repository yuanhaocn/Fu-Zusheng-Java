package com.syc.fdfs.controller;

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
import com.syc.fdfs.Constants;
import com.syc.fdfs.service.UploadService;

@Controller
public class UploadController {

	@Autowired
	private UploadService uploadService;

	// 上传单个图片 @RequestParam(required = false) 防止为null时抛异常.
	@RequestMapping(value = "/upload/uploadPic")
	public void uploadPic(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response)
			throws IOException {

		String path = uploadService.uploadPic(pic.getBytes(), pic.getOriginalFilename(), pic.getSize());
		String url = Constants.IMG_URL + path;
		System.out.println("url=" + url);

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(url);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(json);
	}

	// 上传多张图片
	@ResponseBody
	@RequestMapping(value = "/upload/uploadPics")
	public List<String> uploadPics(@RequestParam(required = false) MultipartFile[] pics, HttpServletResponse response)
			throws IOException {

		List<String> urls = new ArrayList<String>();

		for (MultipartFile pic : pics) {
			String path = uploadService.uploadPic(pic.getBytes(), pic.getOriginalFilename(), pic.getSize());
			String url = Constants.IMG_URL + path;
			urls.add(url);
		}

		return urls;
	}

}
