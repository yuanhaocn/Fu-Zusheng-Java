package com.syc.oa.service;

import com.syc.oa.domain.TbDoc;
import com.syc.oa.vo.PageBean;

public interface DocumentService {

	public boolean saveDocument(TbDoc document);

	public PageBean<TbDoc> selectDocument(String title);

	public void removeOne(Integer id);

	public boolean removeMore(Integer[] ids);
}
