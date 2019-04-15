package com.syc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.common.pojo.EasyUIDataGridResult;
import com.syc.service.ItemService;

/**
 * 商品列表页面
 * @类名称:ItemController
 * @创建人:一一哥
 * @创建时间:2017年11月10日 上午9:18:20
 */
@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	/**
	 * 分页查询所有商品,/item/list
	 * @方法名称:findItems
	 * @创建时间:2017年11月10日 上午9:18:39   
	 * @返回类型:EasyUIDataGridResult
	 */
	@ResponseBody
	@RequestMapping("/list")
	public EasyUIDataGridResult findItems(Integer page, Integer rows) {
		return itemService.findItemByPage(page, rows);
	}
	
}
