package com.syc.hibernate.dao;

import java.util.List;
import java.util.Map;

/*
 * 通用的Dao接口
 */
public interface CommonDao<T> {

	//全部查询
	public List<T> queryAll();
	
	//按条件查询
	public List<T> queryByCondition(Map<String,Object> conditions);
	
	//统计表的数量
	public Long getCount();
	
	//增删改....
}
