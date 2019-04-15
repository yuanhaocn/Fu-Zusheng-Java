package com.syc.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

	public static String url = null;
	public static String user = null;
	public static String password = null;

	// 在静态代码块中读取配置文件
	static {
		try {
			Properties props = new Properties();
			// ./src/db.properties 在JavaSE中, .表示项目的根目录
			// /表示src根目录.
			// 获取代表资源文件的输入流
			InputStream is = JdbcUtil.class.getResourceAsStream("/db.properties");
			// 加载配置文件的流
			props.load(is);
			// 根据key去读取properties配置文件中的内容
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			String driverClass = props.getProperty("driverClass");
			// 注册驱动
			Class.forName(driverClass);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("数据库驱动失败:" + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	//加载配置信息的第二种方式:
	/*static {
		try {
			//ResourceBundle:加载本地资源
			ResourceBundle bundle = ResourceBundle.getBundle("db");
			url = bundle.getString("url");
			user = bundle.getString("user");
			password = bundle.getString("password");
			String driverClass = bundle.getString("driverClass");
			// 注册驱动
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("数据库驱动失败:" + e.getMessage());
			throw new RuntimeException(e);
		}
	}*/

	// 获取数据库连接对象
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 释放资源的方法
	public static void close(Statement stmt, Connection conn) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 释放资源的方法
	public static void close(Statement stmt, Connection conn, ResultSet rs) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
