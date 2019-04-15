package com.syc.bookstore.service;

import com.syc.bookstore.domain.User;
import com.syc.bookstore.exception.UserException;

/**
 * 用户注册的相关接口
 * 
 * @类名称:IUserService
 * @创建人:SYC
 * @创建时间:2017年7月1日 下午11:16:47
 */
public interface IUserService {

	//注册用户
	public void registerUser(User user) throws UserException;

	//激活用户
	public void activeUser(String activeCode) throws UserException;
	
	//查找用户是否存在
	public User findUser(String id) throws UserException;
	
	//用户登录
	public User login(String username,String password) throws UserException;
	
	//修改用户信息
	public void modifyUser(User user) throws UserException;
	
	
}
