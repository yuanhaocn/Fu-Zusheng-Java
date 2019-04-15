package com.syc.book.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.syc.book.dao.IUserDao;
import com.syc.book.domain.User;
import com.syc.book.utils.C3P0Util;

/**
 * Dao层User模块的具体实现
 * 
 * @类名称:UserDaoImpl
 * @创建人:SYC
 * @创建时间:2017年8月4日 上午9:53:35
 */
public class UserDaoImpl implements IUserDao {

	// user表添加用户
	@Override
	public void addUser(User user) throws SQLException {
		// QueryRunner qr = new QueryRunner(C3P0Util.getSource());

		String sql = "insert into user (username,password,gender,email,telephone,introduce,activeCode,state,role,registTime) values(?,?,?,?,?,?,?,?,?,?)";
		C3P0Util.getQueryRunner().update(sql, user.getUsername(), user.getPassword(), user.getGender(), user.getEmail(),
				user.getTelephone(), user.getIntroduce(), user.getActiveCode(), user.getState(), user.getRole(),
				user.getRegistTime());
	}

	// 根据用户名和密码查询用户
	@Override
	public User findByNameAndPass(String name, String pass) throws SQLException {
		String sql = "select * from user where username=? and password=?";
		return C3P0Util.getQueryRunner().query(sql, new BeanHandler<>(User.class), name, pass);
	}

	// 根据激活码查找用户
	@Override
	public User findUserByActiveCode(String activeCode) throws SQLException {
		String sql = "select * from user where activeCode=?";
		return C3P0Util.getQueryRunner().query(sql, new BeanHandler<>(User.class), activeCode);
	}

	// 更新用户激活状态
	@Override
	public void updateUserState(String activeCode) throws SQLException {
		String sql = "update user set state=1 where activeCode=?";
		C3P0Util.getQueryRunner().update(sql, activeCode);
	}

	// 根据id查找用户
	@Override
	public User findUserById(String id) throws SQLException {
		String sql = "select * from user where id=?";
		return C3P0Util.getQueryRunner().query(sql, new BeanHandler<>(User.class), id);
	}

	// 修改用户信息
	@Override
	public void updateUser(User user) throws SQLException {
		String sql = "update user set password=?,telephone=?,gender=? where id=?";
		C3P0Util.getQueryRunner().update(sql, user.getPassword(), user.getTelephone(), user.getGender(), user.getId());
	}

}
