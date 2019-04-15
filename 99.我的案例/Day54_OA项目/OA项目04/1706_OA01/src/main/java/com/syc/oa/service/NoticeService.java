package com.syc.oa.service;

import com.syc.oa.domain.TbAdvice;
import com.syc.oa.vo.PageBean;

public interface NoticeService {

	PageBean<TbAdvice> selectNotice(String title);
	
	boolean addNotice(TbAdvice advice);
	
	TbAdvice selectById(Integer id);
	
	boolean updateNotice(TbAdvice advice);
	
	boolean removeOne(Integer id);
	
	boolean removeMore(Integer[] ids);
}
