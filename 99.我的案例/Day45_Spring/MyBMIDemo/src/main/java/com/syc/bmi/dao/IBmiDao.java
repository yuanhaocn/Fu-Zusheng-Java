package com.syc.bmi.dao;

import java.util.List;

/**
 * 数据访问层
 * @类名称:IBmiDao
 * @创建人:SYC
 * @创建时间:2017年8月3日 上午11:43:28
 */
public interface IBmiDao<T> {

	public boolean add(T t);
	
	public List<T> query();
	
	public boolean delete(T t);
}
