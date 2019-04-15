package com.syc.service;

import com.syc.common.pojo.EasyUIDataGridResult;
import com.syc.common.utils.ShopResult;
import com.syc.pojo.TbItem;

/*
 * 商品条目的接口
 */
public interface ItemService {

	//第1天: 分页查询商品
	EasyUIDataGridResult findItemsByPage(Integer pageNum,Integer pageSize);
	
	//第3天: 添加商品 功能
	ShopResult addItem(TbItem item,String desc,String itemParams) throws Exception;
}
