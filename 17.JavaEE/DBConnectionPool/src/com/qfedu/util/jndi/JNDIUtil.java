package com.qfedu.util.jndi;
/**
 * 这个获取连接的方式不用掌握
 */
import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JNDIUtil {
	public static Connection getConnection() throws Exception{
		//1.获取context的上下文对象
		InitialContext initialContext = new InitialContext();
		//2.加载context.xml
		DataSource dataSource = (DataSource)initialContext.lookup("java:/comp/env/lemon");
		//3.获取连接
		Connection connection = dataSource.getConnection();
		//4.返回连接
		return connection;
	}
}



