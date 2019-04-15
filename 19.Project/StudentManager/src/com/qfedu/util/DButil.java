package com.qfedu.util;

/**
 * 改进是的成为C3p0连接池
 */
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DButil {
	public static Connection getConnection(){
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		Connection connection=null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}
