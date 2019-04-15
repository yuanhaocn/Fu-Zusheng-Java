package com.syc.service;

import com.syc.common.utils.ShopResult;

/*
 * 商品规格接口
 */
public interface ItemParamService {

	//根据商品分类添加商品规格模板
	ShopResult addItemParam(Long itemCatId,String paramData);
	
	//根据商品分类ID查找商品规格模板
	ShopResult findItemParamByCatId(Long itemCatId);
}
