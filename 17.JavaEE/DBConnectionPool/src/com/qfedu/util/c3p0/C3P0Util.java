package com.qfedu.util.c3p0;

import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	public static Connection getConnection() throws Exception {
		// 1.��ȡ����Դ
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		//2.��ȡ����
		Connection connection = dataSource.getConnection();
		return connection;
	}
}
