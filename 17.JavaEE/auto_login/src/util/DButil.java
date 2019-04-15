package util;



import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {
	public static Connection  getConnection(String username,String password,String dbName) {
		Connection connection = null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//构建url对象
			String url = "jdbc:mysql://localhost:3306/"+dbName+"?useUnicode=true&characterEncoding=utf-8";
			//获取连接
			connection = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
