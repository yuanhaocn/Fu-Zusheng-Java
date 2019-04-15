package com.syc.utils.queryrunner04;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.junit.Test;

import com.syc.utils.JdbcUtil;
import com.syc.utils.bean.User;

public class QueryRunnerDemo {

	@Test
	public void query01() {
		Connection conn = JdbcUtil.getConnection();
		String sql = "select * from user where username=?";
		try {
			// 创建一个QueryRunner对象
			QueryRunner qr = new QueryRunner();
			// 执行查询.ResultSetHandler,结果集处理器
			// ResultSetHandler就是接口回调.
			User user = qr.query(conn, sql, new ResultSetHandler<User>() {
				@Override
				public User handle(ResultSet rs) throws SQLException {
					if (rs != null) {
						if (rs.next()) {
							try {
								int id = rs.getInt("id");
								String username = rs.getString("username");
								String password = rs.getString("password");
								User user = new User();
								BeanUtils.setProperty(user, "id", id);
								BeanUtils.setProperty(user, "username", username);
								BeanUtils.setProperty(user, "password", password);
								return user;
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								e.printStackTrace();
							}
						}
					}
					return null;
				}
			}, "土鳖");

			System.out.println(user.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void queryByIdTest() {
		try {
			Connection conn = JdbcUtil.getConnection();
			String sql = "select * from user where id=?";
			QueryRunner qr = new QueryRunner();

			// BeanHandler:将查询结果集的第一行封装为Bean.
			User user = qr.query(conn, sql, new BeanHandler<>(User.class), 2);

			System.out.println(user.toString());

			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void queryAllTest() {
		try {
			Connection conn = JdbcUtil.getConnection();
			String sql = "select * from user";
			QueryRunner qr = new QueryRunner();

			// BeanListHandler:将查询结果集的每一行封装为Bean,并且会把每一个Bean都填充到List中.
			List<User> users = qr.query(conn, sql, new BeanListHandler<>(User.class));

			for (User user : users) {
				System.out.println(user.toString());
			}

			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void queryTest() {
		try {
			Connection conn = JdbcUtil.getConnection();
			//String sql = "select * from user";
			QueryRunner qr = new QueryRunner();

			// ArrayHandler:将查询结果集的第一行封装为Array.
			//Object[] query = qr.query(conn, sql, new ArrayHandler());
			//将数组变为集合
			//System.out.println(Arrays.asList(query));
			
			//ArrayListHandler,将查询结果集的每一行封装为Array,并且会把每一个Array都填充到List中.
			//List<Object[]> users = qr.query(conn, sql, new ArrayListHandler());
			//for(Object[] objs: users){
			//	System.out.println(Arrays.asList(objs));
			//}
			
			//ScalarHandler:将查询结果集中的某一列给返回,该Handler常与聚合函数配合使用.
			//String sql = "select count(*) from user";
			//Long count = qr.query(conn, sql, new ScalarHandler<Long>());
			//System.out.println("员工数量="+count);
			
			//String sql = "select * from user where id=?";
			//String username = qr.query(conn, sql, new ScalarHandler<String>("username"),2);
			//System.out.println("员工姓名="+username);
			
			//MapHandler:将结果集中的第一行,封装为Map进行输出.Map的key是列名.
			String sql = "select * from user";
			//Map<String, Object> map = qr.query(conn, sql, new MapHandler());
			//System.out.println(map.get("username"));
			
			//MapListHandler:将结果集中的每一行都封装为Map进行,并且把map封装到一个List中.
			//Map的key是列名
			//List<Map<String, Object>> maps = qr.query(conn, sql, 
			//new MapListHandler());
			//System.out.println(maps.get(0).get("password"));
			
			//ColumnListHandler:将结果集中的每一行的对应列的封装到一个集合中
			//List<Object> names = qr.query(conn, sql, new ColumnListHandler<>("username"));
			//System.out.println(names.get(1));
			
			//BeanMapHandler:将查询结果集的每一行都封装进一个Map中.
			//Map<Object, User> map = qr.query(conn, sql, new BeanMapHandler<>(User.class));
			//默认情况下,Map的key是User类的id.
			//System.out.println(map.get(2).getUsername());
			
			//KeyedHandler:将查询结果集的每一行都封装为一个map,并且将这个map再封装进一个map中,外面map的key是指定的列的值.
			Map<Object, Map<String, Object>> maps = qr.query(conn, sql, new KeyedHandler<>("username"));
			System.out.println(maps.get("土鳖").get("password"));
			
			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
