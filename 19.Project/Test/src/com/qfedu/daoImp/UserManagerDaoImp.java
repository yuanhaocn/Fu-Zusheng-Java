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
		// 构建SQL语句
		String sql = "select username from user_login where username=? and password=md5(?)";
		 
		// 构建qr对象
		QueryRunner queryRunner = new QueryRunner();
		// 生命UserExt对象
		UserExt ue = null;
		try {
			// 执行sql
			String username = (String) queryRunner.query(connection, sql, new ScalarHandler<>(),
					userLogin.getUsername(), userLogin.getPassword());
			// 构建sql字符串
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
		// 构建SQL语句
				String sql = "select username from user_login where username=? and password=md5(?)";
				 
				// 构建qr对象
				QueryRunner queryRunner = new QueryRunner();
				// 生命UserExt对象
				 int update=0;
				try {
					// 执行sql
					String username = (String) queryRunner.query(connection, sql, new ScalarHandler<>(),
							userLogin.getUsername(), userLogin.getPassword());
					// 构建sql字符串
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
