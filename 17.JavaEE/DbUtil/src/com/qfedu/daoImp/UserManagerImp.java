package com.qfedu.daoImp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.qfedu.domain.User;
import com.qfedu.util.C3P0Util;

public class UserManagerImp {
	private Connection connection = C3P0Util.getConnection();

	/*
	 *  构建qr对象
	 *  添加对象
	 */
	public void insertUser(User user) {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "insert into user values(?,password(?))";
		try {
			int i = queryRunner.update(connection, sql, user.getNumber(), user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 修改
	 */
	public void updateUser(User user) {
		//可以使用数据源构建qr对象，此时在下面的操作中，不需要connection对象了
		QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
		String sql="update user set password=md5(?) where number=?";
		//可以省略connection对象
		try {
			queryRunner.update(sql, user.getPassword(),user.getNumber());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 删除
	 */
	public void deleteUser(User user) {
		//可以使用数据源构建qr对象，此时在下面的操作中，不需要connection对象了
		QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
		String sql="delete from user where number=?";
		try {
			queryRunner.update(sql, user.getNumber());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 完成对user表中所有对象的查询
	 */
	public List<User> selectAllUsers(){
		QueryRunner queryRunner = new QueryRunner();
		String sql="select * from user";
		/*
		 * ResultSerHandler接口的实现类
		 * BeanListHandler封装数据进入集合，并且把该集合返回
		 * 泛型是要封装对象的类型
		 * 参数是要封装对象类型的class对象
		 */
		List<User> users=null;
		try { 
			users = queryRunner.query(connection, sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	/*
	 * 聚合函数
	 */
	public int countUsers() {
		//可以使用数据源构建qr对象，此时在下面的操作中，不需要connection对象了
		QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
		String sql="select count(*) from user";
		Integer count=null;
		try {
			//ScalarHandler的泛型必须是long类型
			Long i = queryRunner.query(connection, sql, new ScalarHandler<Long>());
		//把long 转为integer
			 count = new Integer(count.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}










