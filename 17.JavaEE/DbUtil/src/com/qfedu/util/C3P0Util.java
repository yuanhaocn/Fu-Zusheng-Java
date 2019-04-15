package com.qfedu.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	public static Connection getConnection()  {
		// 1.获取数据源
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		//2.获取连接
		Connection connection=null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
