package com.qfedu.util;

/**
 * �Ľ��ǵĳ�ΪC3p0���ӳ�
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
