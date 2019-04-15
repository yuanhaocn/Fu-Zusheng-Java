package com.qfedu.util.jndi;
/**
 * �����ȡ���ӵķ�ʽ��������
 */
import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JNDIUtil {
	public static Connection getConnection() throws Exception{
		//1.��ȡcontext�������Ķ���
		InitialContext initialContext = new InitialContext();
		//2.����context.xml
		DataSource dataSource = (DataSource)initialContext.lookup("java:/comp/env/lemon");
		//3.��ȡ����
		Connection connection = dataSource.getConnection();
		//4.��������
		return connection;
	}
}



