package com.syc.service;

import java.util.List;

import com.syc.common.pojo.EasyTreeNode;

//商品分类接口
public interface ItemCatService {

	//查询商品分类，根据分类的id
	public List<EasyTreeNode> findItemCatList(long parentId);
}
