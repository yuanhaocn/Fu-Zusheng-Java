package com.syc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.syc.dao.IUserDao;
import com.syc.entity.User;
import com.syc.utils.JdbcUtil;

/**
 * User表的具体实现
 * 
 * @author 一一哥
 * @Description:
 */
public class UserDao implements IUserDao<User> {

	@Override
	public List<User> findUsers() {
		try {
			QueryRunner qr = JdbcUtil.getQueryRunner();
			String sql = "select id,username from users";
			return qr.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
