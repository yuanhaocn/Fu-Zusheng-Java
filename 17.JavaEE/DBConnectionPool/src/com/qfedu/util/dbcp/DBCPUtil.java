package com.qfedu.util.dbcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBCPUtil {
	public static Connection getConnection() throws Exception, IOException {
		// ����property���󣬼��������ļ�
		Properties properties = new Properties();
		properties.load(new FileInputStream("C://Users//FZS//eclipse-workspace//Day16AM//src//com//qfedu//util//dbcp//dbcp.properties"));
		// 2.������������Դ����,��������Դ����
		BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
		//3.ͨ��DataSource�����ȡ���Ӷ���
		Connection connection = dataSource.getConnection();
		return connection;
	}
}
