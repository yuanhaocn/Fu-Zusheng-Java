package com.syc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.common.utils.ShopResult;
import com.syc.pojo.TbContent;
import com.syc.service.ContentService;

/**
 * 内容管理的控制器
 * @类名称:ContentController
 * @创建人:一一哥
 * @创建时间:2017年11月20日 下午10:14:05
 */
@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/save")
	@ResponseBody
	private ShopResult addContent(TbContent content){
		return contentService.addContent(content);
	}
}
