package com.syc.portal.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syc.common.utils.JsonUtils;
import com.syc.pojo.TbContent;
import com.syc.portal.service.ContentService;

@Controller
public class IndexController {

	@Autowired
	private ContentService contentService;
	
	//展示index首页,并且要在这里展示广告轮播图
	@RequestMapping("/index")
	public String goToIndex(Model model){
		
		//广告轮播图的分类是固定的,就是89!
		List<TbContent> contents = contentService.getContentList(89);
		
		List<Map<String,Object>> maps=new ArrayList<>();
		for(TbContent content : contents){
			Map<String, Object> map=new HashMap<>();
			map.put("src", content.getPic());
			map.put("width", 670);
			map.put("height", 240);
			map.put("srcB",content.getPic2());
			map.put("widthB", 550);
			map.put("heightB", 240);
			map.put("href", content.getUrl());
			map.put("alt", content.getTitle());
			maps.add(map);
		}
		
		String json = JsonUtils.objectToJson(maps);
		System.out.println("json="+json);
		model.addAttribute("ad1", json);
		return "index";
	}
}
