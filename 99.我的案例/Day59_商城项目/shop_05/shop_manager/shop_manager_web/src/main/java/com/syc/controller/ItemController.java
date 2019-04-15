package com.syc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.common.pojo.EasyUIDataGridResult;
import com.syc.common.utils.ShopResult;
import com.syc.pojo.TbItem;
import com.syc.service.ItemService;

/*
 * 商品条目控制器
 */
@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	//分页显示商品列表,注意该方法中的参数名称是固定的!
	@RequestMapping("/list")
	@ResponseBody//RestFul风格,以JSON格式返回.
	public EasyUIDataGridResult findItems(Integer page, Integer rows) {
		
		return itemService.findItemsByPage(page, rows);
	}
	
	//添加商品
	@RequestMapping("/save")
	@ResponseBody
	public ShopResult addItem(TbItem item,String desc,String itemParams){
		try {
			return itemService.addItem(item, desc, itemParams);
		} catch (Exception e) {
			e.printStackTrace();
			return ShopResult.build(250, "商品添加失败");
		}
	}
}
