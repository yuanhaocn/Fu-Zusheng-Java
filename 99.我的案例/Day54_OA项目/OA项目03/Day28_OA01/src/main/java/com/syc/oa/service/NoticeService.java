package com.syc.oa.service;

import com.syc.oa.domain.TbAdvice;
import com.syc.oa.vo.PageBean;

public interface NoticeService {

	public PageBean<TbAdvice> selectNotice(String title);
	
	public boolean addNotice(TbAdvice advice);
	
	public TbAdvice selectById(Integer id);
	
	public boolean updateNotice(TbAdvice advice);

	public void removeOne(Integer id);

	public void removeMore(Integer[] ids);
}
