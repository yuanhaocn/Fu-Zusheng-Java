package com.qfedu.util.myDbConnectionPool;

/**
 * 创建自己的连接池
 */
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class MyDatabasePool implements DataSource {
	
	public static List<Connection> connections = new ArrayList<>();
	
	/*
	 * 静态代码块
	 * 完成集合的填充
	 */
	static {

		for (int i = 0; i < 10; i++) {
			connections.add(DBUtil.getConnection());
		}
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() throws SQLException {
		//声明Connection对象
		Connection connection = null;
		//先获取一个connection对象
		if(connections.size()>0) {
			connection = connections.get(connections.size()-1);
			//从集合中移除我们的Connection对象
			connections.remove(connections.size()-1);
		}
		return connection;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
