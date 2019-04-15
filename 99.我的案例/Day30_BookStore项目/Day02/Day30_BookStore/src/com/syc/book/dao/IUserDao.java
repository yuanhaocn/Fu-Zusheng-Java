package com.syc.book.dao;

import java.sql.SQLException;

import com.syc.book.domain.User;

/**
 * Dao层中用户模块.
 * @类名称:IUserDao
 * @创建人:SYC
 * @创建时间:2017年8月4日 上午9:50:53
 */
public interface IUserDao {

	//添加用户到user表
	public void addUser(User user) throws SQLException;
	
	//根据用户名和密码查询用户
	public User findByNameAndPass(String name,String pass) throws SQLException;
	
	//根据激活码查找对应用户
	public User findUserByActiveCode(String activeCode) throws SQLException;
	
	//更新用户激活状态
	public void updateUserState(String activeCode) throws SQLException;
	
	//根据id查找用户
	public User findUserById(String id) throws SQLException;
	
	//修改用户信息
	public void updateUser(User user) throws SQLException;
}
