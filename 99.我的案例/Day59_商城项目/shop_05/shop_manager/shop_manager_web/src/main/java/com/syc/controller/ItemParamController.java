package com.syc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.common.utils.ShopResult;
import com.syc.service.ItemParamService;

/*
 * 商品规格控制器
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {

	@Autowired
	private ItemParamService itemParamService;
	
	/*
	 * 添加商品规格模板
	 */
	@RequestMapping("/save/{itemCatId}")
	@ResponseBody
	public ShopResult addItemParam(@PathVariable Long itemCatId,String paramData){
		return itemParamService.addItemParam(itemCatId, paramData);
	}
	
	/*
	 * 根据商品分类id查找商品规格模板
	 */
	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public ShopResult findItemParamByCatId(@PathVariable Long itemCatId){
		return itemParamService.findItemParamByCatId(itemCatId);
	}
}
