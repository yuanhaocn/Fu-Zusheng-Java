package com.syc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.common.pojo.TreeNode;
import com.syc.common.utils.ShopResult;
import com.syc.service.ContentCategoryService;

/**
 * 内容分类管理的控制器类
 * 
 * @类名称:ContentCategoryController
 * @创建人:一一哥
 * @创建时间:2017年11月16日 下午5:48:53
 */
@Controller()
@RequestMapping("/content/category")
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService categoryService;

	@RequestMapping("/list")
	@ResponseBody
	public List<TreeNode> getContentCategoryList(@RequestParam(value = "id", defaultValue = "0") long parentId) {
		return categoryService.getContentCategoryList(parentId);
	}

	@RequestMapping("/create")
	@ResponseBody
	public ShopResult createNode(long parentId, String name) {
		return categoryService.createNode(parentId, name);
	}

	@RequestMapping("/update")
	@ResponseBody
	public ShopResult updateNode(long id, String name) {
		return categoryService.renameNode(id, name);
	}

	@RequestMapping("/delete")
	@ResponseBody
	public ShopResult deleteNode(long id) {
		return categoryService.deleteNode(id);
	}
}
