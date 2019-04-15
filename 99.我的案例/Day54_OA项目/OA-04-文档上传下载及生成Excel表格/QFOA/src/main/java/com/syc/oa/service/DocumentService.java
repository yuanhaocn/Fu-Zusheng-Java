package com.syc.oa.service;

import java.util.Map;

import com.syc.oa.domain.TbDoc;
import com.syc.oa.vo.PageBean;

public interface DocumentService {

	/**
	 * 文档的添加
	 */
	public boolean saveDocument(Integer uid, TbDoc document);

	/**
	 * 文档查询
	 */
	public PageBean<TbDoc> selectDocument(Map<String, Object> map);

	public boolean removeById(Integer id);

	public boolean removeMore(Integer[] ids);

}
