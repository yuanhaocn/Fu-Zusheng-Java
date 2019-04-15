package com.syc.bookstore.dao;

import java.sql.SQLException;

import com.syc.bookstore.domain.User;

/**
 * dao层的用户接口
 * 
 * @类名称:IUserDao
 * @创建人:SYC
 * @创建时间:2017年7月1日 下午11:29:11
 */
public interface IUserDao {

	// 添加用户
	public void addUser(User user) throws SQLException;

	// 修改用户激活状态
	public void updateActiveState(String activeCode) throws SQLException;

	// 查找用户
	public User findUserByUserNameAndPassWord(String username, String password) throws SQLException;

	public User findUserById(String id) throws SQLException;

	public User findUserByActiveCode(String activeCode) throws SQLException;

	// 修改用户
	public void updateUser(User user) throws SQLException;
}
