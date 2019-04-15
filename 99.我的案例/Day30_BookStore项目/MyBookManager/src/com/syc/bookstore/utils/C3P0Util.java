package com.syc.bookstore.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * C3P0连接池工具类
 * 
 * @类名称:C3P0Util
 * @创建人:SYC
 * @创建时间:2017年7月6日 下午1:31:27
 */
public class C3P0Util {

	// 定义连接池对象
	public static ComboPooledDataSource source = null;
	static {
		source = new ComboPooledDataSource();
	}

	// 获取ComboPooledDataSource数据源
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
		} else {
			return null;
		}
	}

	// 关闭连接
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
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

}
