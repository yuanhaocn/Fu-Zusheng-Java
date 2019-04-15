package com.qfedu.util.myDbConnectionPool;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
	public static Connection getConnection() {
		//����property����
		Properties properties = new Properties();
		Connection connection = null;
		try {
			//����properties�ļ�
			properties.load(new FileInputStream("C://Users//FZS//eclipse-workspace//Day16AM//src//com//qfedu//util//myDbPool//settings.properties"));
			//����getProperty
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			String dbname = properties.getProperty("dbname");
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/"+dbname+"?useUnicode=true&characterEncoding=utf-8";
			//��ȡ����
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}
