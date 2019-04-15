package util;



import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {
	public static Connection  getConnection(String username,String password,String dbName) {
		Connection connection = null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//����url����
			String url = "jdbc:mysql://localhost:3306/"+dbName+"?useUnicode=true&characterEncoding=utf-8";
			//��ȡ����
			connection = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
