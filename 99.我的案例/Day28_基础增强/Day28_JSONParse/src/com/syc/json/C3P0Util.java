package com.syc.json;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 加载C3P0连接池的工具类
 * 
 * @类名称:C3P0Util
 * @创建人:SYC
 * @创建时间:2017年7月31日 下午2:48:18
 */
public class C3P0Util {

	private static ComboPooledDataSource source = null;

	static {
		// 在new数据源的时候就会自动加载c3p0-config.xml文件.
		source = new ComboPooledDataSource();
	}

	public static DataSource getDataSource() {
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

	public void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
