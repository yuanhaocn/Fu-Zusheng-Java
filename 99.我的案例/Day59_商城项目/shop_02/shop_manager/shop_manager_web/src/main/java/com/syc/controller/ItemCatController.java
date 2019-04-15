package com.syc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.common.pojo.EasyTreeNode;
import com.syc.service.ItemCatService;

/*
 * 商品条目分类
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService catService;
	
	//easyui会给controller传递参数id
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyTreeNode> findItemCats(@RequestParam(value="id",defaultValue="0") Long parentId){
		return catService.findItemCatList(parentId);
	}
}
