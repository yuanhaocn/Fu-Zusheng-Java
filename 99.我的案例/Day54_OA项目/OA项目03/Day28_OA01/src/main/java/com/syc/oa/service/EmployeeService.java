package com.syc.oa.service;

import java.util.Map;

import com.syc.oa.domain.TbEmployee;
import com.syc.oa.vo.PageBean;

public interface EmployeeService {

	PageBean<TbEmployee> selectEmployee(Map<String, Object> map);

	boolean addEmployee(TbEmployee employee);
	
	public TbEmployee findById(Integer id);

	public boolean updateEmployee(TbEmployee employee);

	void removeOne(Integer id);
	
	void removeMore(Integer[] ids);
}
