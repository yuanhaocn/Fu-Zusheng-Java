package com.syc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.common.pojo.EasyTreeNode;
import com.syc.service.ItemCatService;

/**
 * 商品分类的控制器
 * @类名称:ItemCatController
 * @创建人:一一哥
 * @创建时间:2017年11月10日 上午10:21:13
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService catService;
	
	/**
	 * 查询所有的商品分类信息
	 * @方法名称:findItemCats
	 * @创建时间:2017年11月10日 上午10:22:24   
	 * @返回类型:void
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<EasyTreeNode> findItemCats(@RequestParam(value="id",defaultValue="0") Long parentId){
		return catService.findItemCatList(parentId);
	}
}
