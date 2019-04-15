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
	 *  ����qr����
	 *  ��Ӷ���
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
	 * �޸�
	 */
	public void updateUser(User user) {
		//����ʹ������Դ����qr���󣬴�ʱ������Ĳ����У�����Ҫconnection������
		QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
		String sql="update user set password=md5(?) where number=?";
		//����ʡ��connection����
		try {
			queryRunner.update(sql, user.getPassword(),user.getNumber());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * ɾ��
	 */
	public void deleteUser(User user) {
		//����ʹ������Դ����qr���󣬴�ʱ������Ĳ����У�����Ҫconnection������
		QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
		String sql="delete from user where number=?";
		try {
			queryRunner.update(sql, user.getNumber());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * ��ɶ�user�������ж���Ĳ�ѯ
	 */
	public List<User> selectAllUsers(){
		QueryRunner queryRunner = new QueryRunner();
		String sql="select * from user";
		/*
		 * ResultSerHandler�ӿڵ�ʵ����
		 * BeanListHandler��װ���ݽ��뼯�ϣ����ҰѸü��Ϸ���
		 * ������Ҫ��װ���������
		 * ������Ҫ��װ�������͵�class����
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
	 * �ۺϺ���
	 */
	public int countUsers() {
		//����ʹ������Դ����qr���󣬴�ʱ������Ĳ����У�����Ҫconnection������
		QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
		String sql="select count(*) from user";
		Integer count=null;
		try {
			//ScalarHandler�ķ��ͱ�����long����
			Long i = queryRunner.query(connection, sql, new ScalarHandler<Long>());
		//��long תΪinteger
			 count = new Integer(count.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}










