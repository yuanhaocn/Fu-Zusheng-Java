package com.syc.oa.service;

import java.util.Map;

import com.syc.oa.domain.TbDoc;
import com.syc.oa.vo.PageBean;

/**
 * 下载中心模块的Service层接口----文档查询及添加
 * @类名称:DocumentService
 * @创建人:SYC
 * @创建时间:2017年11月3日 上午9:49:47
 */
public interface DocumentService {

	/**
	 * 保存文档
	 */
	public boolean saveDocument(Integer uid, TbDoc document);

	/**
	 * 文档查询
	 */
	public PageBean<TbDoc> findDocument(Map<String, Object> map);

	/**
	 * 删除单个文档
	 */
	public boolean removeOne(Integer id);

	/**
	 * 批量删除文档
	 */
	public boolean removeMore(Integer[] ids);

}
