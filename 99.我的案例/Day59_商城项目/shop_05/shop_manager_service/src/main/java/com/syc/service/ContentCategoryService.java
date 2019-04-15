package com.syc.service;

import java.util.List;

import com.syc.common.pojo.TreeNode;
import com.syc.common.utils.ShopResult;

/**
 * 内容分类接口
 * @类名称:ContentCategoryService
 * @创建人:一一哥
 * @创建时间:2017年11月16日 下午5:38:01
 */
public interface ContentCategoryService {

	/**
	 * 获取内容分类列表
	 */
	public List<TreeNode> getContentCategoryList(long parentId);
	
	/**
	 * 创建节点
	 */
	public ShopResult createNode(long parentId,String name);
	
	/**
	 * 重命名节点
	 */
	public ShopResult renameNode(long id,String name);
	
	/**
	 * 删除节点
	 */
	public ShopResult deleteNode(long id);
}
