package com.syc.bookstore.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.syc.bookstore.dao.IUserDao;
import com.syc.bookstore.domain.User;
import com.syc.bookstore.utils.C3P0Util;

/**
 * dao层,User相关实现
 * 
 * @类名称:UserDaoImpl
 * @创建人:SYC
 * @创建时间:2017年7月1日 下午11:30:23
 */
public class UserDaoImpl implements IUserDao {

	@Override
	public void addUser(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "INSERT INTO user (username,PASSWORD,gender,email,telephone,introduce,activeCode,state,registTime) VALUES(?,?,?,?,?,?,?,?,?)";
		qr.update(sql, user.getUsername(), user.getPassword(), user.getGender(), user.getEmail(), user.getTelephone(),
				user.getIntroduce(), user.getActiveCode(), user.getState(), user.getRegistTime());
	}

	@Override
	public User findUserByUserNameAndPassWord(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "SELECT * FROM user WHERE username=? AND password=?";
		// 查询结果,通过BeanHander将结果封装到User对象中.
		return qr.query(sql, new BeanHandler<>(User.class), username, password);
	}

	@Override
	public User findUserById(String id) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="SELECT * FROM user WHERE id=?";
		return qr.query(sql, new BeanHandler<User>(User.class),id);
	}

	//根据激活码查询用户信息
	@Override
	public User findUserByActiveCode(String activeCode) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "SELECT * FROM user WHERE activeCode=?";
		return qr.query(sql, new BeanHandler<User>(User.class), activeCode);
	}

	//更新用户激活状态
	@Override
	public void updateActiveState(String activeCode) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "UPDATE user SET state=1 WHERE activeCode=?";
		qr.update(sql, activeCode);
	}

	//修改用户信息
	@Override
	public void updateUser(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql="UPDATE user SET password=?,gender=?,telephone=? WHERE id=?";
		qr.update(sql,user.getPassword(),user.getGender(),user.getTelephone(),user.getId());
	}

}
