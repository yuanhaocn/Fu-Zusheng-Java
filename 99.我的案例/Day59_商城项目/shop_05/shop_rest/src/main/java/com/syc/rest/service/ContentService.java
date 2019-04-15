package com.syc.rest.service;

import com.syc.common.utils.ShopResult;

/**
 * 内容管理的服务接口
 * @类名称:ContentService
 * @创建人:一一哥
 * @创建时间:2017年11月21日 下午5:28:41
 */
public interface ContentService {

	/**
	 * 获取内容列表
	 */
	public ShopResult getContentList(long categoryId);
}
