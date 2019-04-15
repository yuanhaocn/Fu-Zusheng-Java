package com.syc.ssh.dao;

import java.sql.SQLException;

import com.syc.ssh.domain.User;

public interface IUserDao {

	// 添加用户的方法
	public void insert(User user) throws SQLException;

	// 根据用户名和密码查询的方法
	public User findByNameAndPass(User user) throws SQLException;
}
