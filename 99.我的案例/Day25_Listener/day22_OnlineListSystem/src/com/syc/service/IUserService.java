package com.syc.service;

import java.util.List;

/**
 * Service层
 * @author 一一哥        
 * @Description:
 */
public interface IUserService<T> {

	public List<T> findUsers();
}
