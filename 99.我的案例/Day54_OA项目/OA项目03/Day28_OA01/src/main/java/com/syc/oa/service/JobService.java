package com.syc.oa.service;

import java.util.List;

import com.syc.oa.domain.TbJob;
import com.syc.oa.vo.PageBean;

public interface JobService {

	public PageBean<TbJob> findJob(String jobName);
	
	public List<TbJob> findAll();
	
	public boolean addJob(TbJob job);
	
	public TbJob findById(Integer id);
	
	public boolean updateJob(TbJob job);
	
	public void removeOne(Integer id);
	
	public void removeMore(Integer[] ids);
}
