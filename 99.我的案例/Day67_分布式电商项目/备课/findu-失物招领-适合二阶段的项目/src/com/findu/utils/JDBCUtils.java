package com.findu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	
	/*private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static{
		ResourceBundle rb=ResourceBundle.getBundle("dbinfo");
		driver=rb.getString("driver");
		url=rb.getString("url");
		username=rb.getString("username");
		password=rb.getString("password");
		
		//1.�������� ��ֹ������ע��2�� ������������jar
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}*/
	
	//�õ�����Դ
	private static DataSource dataSource=new ComboPooledDataSource();

	public static DataSource getDataSource() {
		return dataSource;
	}

	//2.��ȡ���ݿ����ӣ�Connection ����sql��������
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
		//return DriverManager.getConnection(url, user, password);
	}
	
	//4.�ͷ���Դ
	public static void release(ResultSet rs, Statement stat, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (stat != null) {
			try {
				stat.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (conn != null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}