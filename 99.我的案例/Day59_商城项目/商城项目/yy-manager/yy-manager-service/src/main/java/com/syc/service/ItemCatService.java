package com.syc.service;

import java.util.List;

import com.syc.common.pojo.EasyTreeNode;

/**
 * 商品分类的接口
 * @类名称:ItemCatService
 * @创建人:一一哥
 * @创建时间:2017年11月10日 上午10:30:21
 */
public interface ItemCatService {

	public List<EasyTreeNode> findItemCatList(Long parentId);
}
