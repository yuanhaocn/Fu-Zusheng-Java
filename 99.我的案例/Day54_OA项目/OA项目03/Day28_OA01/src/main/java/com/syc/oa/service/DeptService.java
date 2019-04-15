package com.syc.oa.service;

import java.util.List;

import com.syc.oa.domain.TbDept;
import com.syc.oa.vo.PageBean;

public interface DeptService {

	public PageBean<TbDept> findDept(String deptName);
	
	public List<TbDept> findAll();
	
	public boolean addDept(TbDept dept);
	
	public TbDept findById(Integer id);
	
	public boolean updateDept(TbDept dept);
	
	public void removeOne(Integer id);
	
	public void removeMore(Integer[] ids);
}
