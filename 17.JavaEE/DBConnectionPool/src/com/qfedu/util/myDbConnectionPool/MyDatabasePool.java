package com.qfedu.util.myDbConnectionPool;

/**
 * �����Լ������ӳ�
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
	 * ��̬�����
	 * ��ɼ��ϵ����
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
		//����Connection����
		Connection connection = null;
		//�Ȼ�ȡһ��connection����
		if(connections.size()>0) {
			connection = connections.get(connections.size()-1);
			//�Ӽ������Ƴ����ǵ�Connection����
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
