package com.qfedu.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	public static Connection getConnection() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		Connection connection=null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
