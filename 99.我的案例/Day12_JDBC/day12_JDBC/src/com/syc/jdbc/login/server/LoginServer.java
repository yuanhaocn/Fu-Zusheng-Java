package com.syc.jdbc.login.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.syc.jdbc.JdbcUtil;
import com.syc.jdbc.login.bean.User;

public class LoginServer {

	public User login(String name, String pwd) {
		try {
			Connection conn = JdbcUtil.getConnection();
			String sql = "select * from user where username=? and password=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, pwd);
			ResultSet rs = stmt.executeQuery();
			User user = null;
			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				user = new User();
				user.setId(id);
				user.setUsername(username);
				user.setPassword(password);
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
