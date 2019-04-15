package com.syc.bmi.service;

import java.util.List;

//业务逻辑层,业务方法.
public interface IBmiService<T> {

	public boolean addBMI(T t);
	
	public List<T> queryBMI();
	
	public boolean deleteBMI(T t);
}
