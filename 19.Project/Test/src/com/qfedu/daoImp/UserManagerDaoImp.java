package com.qfedu.daoImp;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qfedu.dao.UserManagerDao;
import com.qfedu.domain.PageInfo;
import com.qfedu.domain.UserExt;
import com.qfedu.domain.UserLogin;
import com.qfedu.util.C3P0Util;

public class UserManagerDaoImp implements UserManagerDao {
	private Connection connection = C3P0Util.getConnection();

	@Override
	public UserExt selectUser(UserLogin userLogin) {
		// ����SQL���
		String sql = "select username from user_login where username=? and password=md5(?)";
		 
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
	
	@Override
	public int insertNewPass(UserLogin userLogin) {
		// ����SQL���
				String sql = "select username from user_login where username=? and password=md5(?)";
				 
				// ����qr����
				QueryRunner queryRunner = new QueryRunner();
				// ����UserExt����
				 int update=0;
				try {
					// ִ��sql
					String username = (String) queryRunner.query(connection, sql, new ScalarHandler<>(),
							userLogin.getUsername(), userLogin.getPassword());
					// ����sql�ַ���
					if (username != null) {
						String sql2 = "update user_login set password=md5(?) where username=?";
				  update = queryRunner.update(connection, sql2,userLogin.getNewPassword(),userLogin.getUsername());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return update;
		 
	}

	@Override
	public void InsertPageInfo(PageInfo pageInfo) {
	 String sql="INSERT INTO `send_tie`(theme,sendcontent,senduser,sendtime,updatetime,photo) VALUES(?,?,?,now(),now(),?)";
	 QueryRunner queryRunner = new QueryRunner();
	 try {
		queryRunner.update(connection, sql, pageInfo.getTheme(),pageInfo.getSendContent(),pageInfo.getSendUser(),pageInfo.getPhoto());
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 
	}

}
