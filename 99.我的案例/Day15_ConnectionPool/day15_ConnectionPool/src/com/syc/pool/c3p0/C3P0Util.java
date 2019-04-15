package com.syc.pool.c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {

	public static ComboPooledDataSource source = null;

	static {
		source = new ComboPooledDataSource();
	}

	// 获取数据源
	public static ComboPooledDataSource getDataSource() {
		if (source != null) {
			return source;
		}
		return null;
	}

	// 获取数据库连接对象
	public static Connection getConnection() throws SQLException {
		if (source != null) {
			return source.getConnection();
		}
		return null;
	}

	// 关闭数据库连接对象
	public static void close(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
}
