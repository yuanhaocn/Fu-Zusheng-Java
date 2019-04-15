package com.qfedu.daoImp;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qfedu.dao.UserManagerDao;
import com.qfedu.domain.UserExt;
import com.qfedu.domain.UserLogin;
import com.qfedu.util.C3P0Util;
import com.sun.org.apache.regexp.internal.recompile;

public class UserManagerDaoImp implements UserManagerDao {
	private Connection connection = C3P0Util.getConnection();

	@Override
	public UserExt selectUser(UserLogin userLogin) {
		// ����SQL���
		String sql = "select username from user_login where username=? and password=md5(?)";
		//String sql = "select username from user_login where username=? and password=?";
		// ����qr����
		QueryRunner queryRunner = new QueryRunner();
		// ����UserExt����
		UserExt ue = null;
		try {
			// ִ��sql
			String username = (String) queryRunner.query(connection, sql, new ScalarHandler<>(),
					userLogin.getUsername(), userLogin.getPassword());
			// ����sql�ַ���
			if (username != null) {
				sql = "select username,nickname,email,sendnumber,replynumber from user_info where username = ?";
				ue = queryRunner.query(connection, sql, new BeanHandler<UserExt>(UserExt.class), username);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ue;
	}

}
