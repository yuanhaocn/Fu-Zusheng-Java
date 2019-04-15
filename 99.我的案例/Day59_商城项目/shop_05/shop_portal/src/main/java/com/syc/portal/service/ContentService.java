package com.syc.portal.service;

import java.util.List;

import com.syc.pojo.TbContent;

/**
 * 内容管理的服务类接口
 * @类名称:ContentService
 * @创建人:一一哥
 * @创建时间:2017年11月21日 下午9:49:32
 */
public interface ContentService {

	public List<TbContent> getContentList(long categoryId);
}
