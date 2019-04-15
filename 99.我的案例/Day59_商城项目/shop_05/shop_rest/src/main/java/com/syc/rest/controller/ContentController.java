package com.syc.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.common.utils.ShopResult;
import com.syc.rest.service.ContentService;

/**
 * 内容管理控制器
 * @类名称:ContentController
 * @创建人:一一哥
 * @创建时间:2017年11月21日 下午5:37:55
 */
@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService service;
	
	@ResponseBody
	@RequestMapping("/category/{categoryId}")
	public ShopResult getContentList(@PathVariable Long categoryId){
		return service.getContentList(categoryId);
	}
}
