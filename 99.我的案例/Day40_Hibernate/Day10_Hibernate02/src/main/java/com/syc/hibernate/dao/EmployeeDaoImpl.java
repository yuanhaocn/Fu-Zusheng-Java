package com.syc.hibernate.dao;

import java.util.List;
import java.util.Map;

import com.syc.hibernate.domain.Employee;

public class EmployeeDaoImpl extends CommonDaoImpl<Employee> {

	@Override
	public List<Employee> queryAll() {

		List<Employee> all = super.queryAll();
		
		//可以在通用的实现方法基础之上,进行灵活的扩展(二次加工!)
		return all;
	}
	
	@Override
	public Long getCount() {
		return super.getCount();
	}
	
	@Override
	public List<Employee> queryByCondition(Map<String, Object> conditions) {
		return super.queryByCondition(conditions);
	}
	
	//增加部门表特殊的操作
	
}
