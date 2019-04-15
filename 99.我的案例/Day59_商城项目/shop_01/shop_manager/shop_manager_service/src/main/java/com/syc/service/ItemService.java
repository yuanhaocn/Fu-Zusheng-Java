package com.syc.service;

import com.syc.common.pojo.EasyUIDataGridResult;

/*
 * 商品条目的Service
 */
public interface ItemService {

	//分页查询商品
	EasyUIDataGridResult findItemsByPage(Integer pageNum,Integer pageSize);
}
