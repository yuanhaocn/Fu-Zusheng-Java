package com.syc.book.service;

import com.syc.book.domain.User;
import com.syc.book.exception.UserException;

/**
 * Service中User模块相关的方法.注册,登陆,激活用户,检查用户是否存在,修改用户激活状态等的操作.
 * 
 * @类名称:IUserService
 * @创建人:SYC
 * @创建时间:2017年8月4日 上午9:43:59
 */
public interface IUserService {

	public void registerUser(User user) throws UserException;

	public User login(String name, String pass) throws UserException;

	public void activeUser(String activeCode) throws UserException;

	public User findUser(String id) throws UserException;
	
	public void modifyUser(User user) throws UserException;
}
