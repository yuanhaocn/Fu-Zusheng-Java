package com.syc.utils.dbutils02;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import com.syc.utils.JdbcUtil;

/**
 * MySQL的元数据分类: 1.数据库元数据; 2.参数元数据; 3.结果集元数据. 可以利用这些元数据来获取除了正常的SQL语句之外的信息.
 * 比如数据库名称,版本等.
 * 
 * @类名称:DbMetaData
 * @创建人:SYC
 * @创建时间:2017年7月13日 下午2:16:49
 */
public class DbMetaData {

	// 获取数据库元数据
	@Test
	public void dbMetaData() {
		Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();

			// 数据库元数据.
			// Comprehensive information about the database as a whole.
			// DatabaseMetaData包含了数据库的整体信息.
			DatabaseMetaData metaData = conn.getMetaData();

			// 获取MySQL驱动程序的名称
			String driverName = metaData.getDriverName();
			// 驱动程序的版本号
			String driverVersion = metaData.getDriverVersion();
			// 获取数据库连接的URL地址
			String url = metaData.getURL();
			// 当前数据库的用户名
			String userName = metaData.getUserName();
			System.out.println("driverName=" + driverName);
			System.out.println("driverVersion=" + driverVersion);
			System.out.println("url=" + url);
			System.out.println("userName=" + userName);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(null, conn);
		}
	}

	// 获取参数元数据
	@Test
	public void parameterMetaData() {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from acount where username=? and money=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "三胖");
			stmt.setString(2, "3000");

			// 获取参数元数据
			ParameterMetaData parameterMetaData = stmt.getParameterMetaData();

			// 参数的数量
			int parameterCount = parameterMetaData.getParameterCount();

			// 默认情况下,会报如下异常:
			// java.sql.SQLException:
			// Parameter metadata not available for the given statement.
			// MySQL默认没有开启获取参数元数据信息的功能.
			// 可以在MySQL的连接url后面添加如下语句:
			// ?generateSimpleParameterMetadata=true
			
			// 参数类型名称
			String parameterTypeName1 = parameterMetaData.getParameterTypeName(1);
			String parameterTypeName2 = parameterMetaData.getParameterTypeName(2);
			// 参数类的名称
			String parameterClassName1 = parameterMetaData.getParameterClassName(1);
			String parameterClassName2 = parameterMetaData.getParameterClassName(2);

			System.out.println("parameterCount=" + parameterCount);
			System.out.println("parameterTypeName1=" + parameterTypeName1);
			System.out.println("parameterTypeName2=" + parameterTypeName2);
			System.out.println("parameterClassName1=" + parameterClassName1);
			System.out.println("parameterClassName2=" + parameterClassName2);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}

	// 获取结果集元数据
	@Test
	public void resultSetMetaData() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();

			// String sql = "select * from acount where username=? and money=?";
			// stmt = conn.prepareStatement(sql);
			// stmt.setString(1, "三胖");
			// stmt.setString(2, "3000");

			String sql = "select * from acount";
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			// 1.利用stmt获取结果集元数据
			// ResultSetMetaData metaData = stmt.getMetaData();
			// 2.通过结果集,也可以获取结果集元数据
			ResultSetMetaData metaData = rs.getMetaData();

			// 获取列的数量
			int columnCount = metaData.getColumnCount();
			System.out.println("columnCount=" + columnCount);
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					// 列标签---->就是列名
					String columnLabel = metaData.getColumnLabel(i);
					System.out.println("columnLabel=" + columnLabel);
					// 列名
					String columnName = metaData.getColumnName(i);
					System.out.println("columnName=" + columnName);

					// 列的类型名称
					String type = metaData.getColumnTypeName(i);
					System.out.println("type=" + type);

					// 根据列名得到列中的值
					Object value = rs.getObject(columnName);
					System.out.println("Value=" + value);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn, rs);
		}
	}

}
