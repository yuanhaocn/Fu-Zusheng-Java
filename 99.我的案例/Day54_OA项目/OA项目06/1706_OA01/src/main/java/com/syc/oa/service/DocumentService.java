package com.syc.oa.service;

import com.syc.oa.domain.TbDoc;
import com.syc.oa.vo.PageBean;

public interface DocumentService {

	PageBean<TbDoc> selectDocument(String title);
	
	void removeOne(Integer id);
	
	void removeMore(Integer[] ids);
	
	boolean saveDocument(TbDoc document);
}
