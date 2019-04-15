package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * JDBC����
 */

public class Util {
	static String driverName = Props.findValByKey("driverName");
	static String url = Props.findValByKey("url");
	static String user = Props.findValByKey("user");
	static String password = Props.findValByKey("password");
	static {
		try {
			Class.forName(driverName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ���Ӷ���
	 */
	public static Connection findConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * �ر���Դ����
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public static void closeResource(ResultSet rs, Statement st, Connection conn) {

		try {
			if (rs != null) {
				rs.close();
			}

			if (st != null) {
				st.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}


