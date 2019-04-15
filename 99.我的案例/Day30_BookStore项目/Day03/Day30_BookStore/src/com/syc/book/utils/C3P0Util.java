package com.syc.book.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * C3P0的工具类
 * 
 * @类名称:C3P0Util
 * @创建人:SYC
 * @创建时间:2017年8月4日 上午9:58:39
 */
public class C3P0Util {

	private static ComboPooledDataSource source = null;

	static {
		source = new ComboPooledDataSource();
	}

	public static ComboPooledDataSource getSource() {
		if (source != null) {
			return source;
		}
		return null;
	}

	public static Connection getConnection() throws SQLException {
		if (source != null) {
			return source.getConnection();
		}
		return null;
	}

	public static QueryRunner getQueryRunner() {
		return new QueryRunner(getSource());
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
