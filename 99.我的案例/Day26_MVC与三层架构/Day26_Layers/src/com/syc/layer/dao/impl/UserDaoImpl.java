package com.syc.layer.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.syc.layer.dao.IUserDao;
import com.syc.layer.domain.User;
import com.syc.layer.utils.C3P0Util;

/**
 * 数据访问层的具体实现
 * 
 * @类名称:UserDaoImpl
 * @创建人:SYC
 * @创建时间:2017年7月31日 上午11:55:19
 */
public class UserDaoImpl implements IUserDao {

	@Override
	public void addUser(User user) throws SQLException {
		String sql = "INSERT INTO users (username,password,email,birthday) VALUES(?,?,?,?)";
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getBirthday());

		// JDBC实现数据库操作的步骤:
		// 1.注册驱动;
		// 2.建立连接;
		// 3.获取Statement对象.
		// 4.执行具体的sql语句;
		// 5.关闭资源.
	}

	@Override
	public User findUser(User user) throws SQLException {
		String sql = "SELECT * FROM users WHERE username=? AND password=?";
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query(sql, new BeanHandler<>(User.class), user.getUsername(), user.getPassword());
	}

}
