package com.syc.service;

import com.syc.common.pojo.EasyUIDataGridResult;

/**
 * 关于商品条目的接口
 * @类名称:ItemService
 * @创建人:一一哥
 * @创建时间:2017年11月9日 下午3:44:11
 */
public interface ItemService {

	//分页查询商品信息
	public EasyUIDataGridResult findItemByPage(Integer pageNum,Integer pageSize);
}
