package com.syc.work.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {

	private static String url = null;
	private static String user = null;
	private static String password = null;

	static {
		try {
			Properties props = new Properties();
			InputStream is = JdbcUtil.class.getResourceAsStream("/db.properties");
			props.load(is);

			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");

			// 注册驱动
			String driverClass = props.getProperty("driverClass");
			Class.forName(driverClass);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}
