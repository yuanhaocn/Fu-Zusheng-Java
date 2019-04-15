package com.qfedu.daoimp;
/**
 * 使用C3p0连接池对获取连接进行优化，并且使用Dbutil对查询进行优化
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.qfedu.dao.UserHandle;
import com.qfedu.domain.User;
import com.qfedu.util.DButil;

public class UserHandleImp implements UserHandle {
	private Connection connection = DButil.getConnection();

	@Override
	public boolean selectUserByUsername(User user) {
		String sql = "select password  from user where number = ?";
		QueryRunner queryRunner = new QueryRunner();
		User query = null;
		try {
			query = queryRunner.query(connection, sql, new BeanHandler<User>(User.class), user.getNumber());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if (user.getPassword().equals(query.getPassword())) {
			return true;
		}
		return false;
	}

}
