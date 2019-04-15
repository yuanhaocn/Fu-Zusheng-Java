package com.syc.shiro.dao;

import java.util.List;

public interface UserDao {

	//查找单个对象的方法
	Object findObject(String hql,Object[] args);
	
	//查找多个对象
	List<?> findAll(String hql,Object[] args);
	
}
