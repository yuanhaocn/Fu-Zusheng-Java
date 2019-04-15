package com.syc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.common.pojo.EasyUIDataGridResult;
import com.syc.service.ItemService;

/*
 * 商品条目控制器
 */
@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	//pagination将发送两个参数到服务器:
	//形成url:http://localhost:8080/item/list?page=1&&rows=0的格式.
	//page：页码，起始值 1。
	//rows：每页显示行。
	@RequestMapping("/list")
	@ResponseBody//RestFul风格,以JSON格式返回.
	public EasyUIDataGridResult findItems(Integer page, Integer rows) {
		
		return itemService.findItemsByPage(page, rows);
	}
}
