package com.syc.dao;

import java.util.List;

/**
 * 员工表dao接口
 * @author 一一哥        
 * @Description:
 */
public interface IUserDao<T> {

	public List<T> findUsers();
}
