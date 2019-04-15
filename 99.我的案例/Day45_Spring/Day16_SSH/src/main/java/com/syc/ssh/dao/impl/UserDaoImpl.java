package com.syc.ssh.dao.impl;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.syc.ssh.dao.IUserDao;
import com.syc.ssh.domain.User;

public class UserDaoImpl implements IUserDao {

	// Hibernate的类对象SessionFactory,该对象由Spring容器负责创建
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public void insert(User user) throws SQLException {
		System.out.println("dao层...添加用户...");
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
	}

	@SuppressWarnings({ "rawtypes" })
	public User findByNameAndPass(User user) throws SQLException {
		System.out.println("dao层...查询用户...");

		Session session = factory.openSession();
		Query query = session.createQuery("from User user where user.username=? and user.password=?");
		query.setParameter(0, user.getUsername());
		query.setParameter(1, user.getPassword());
		// List<User> list = query.list();
		User usr = (User) query.uniqueResult();
		session.close();

		return usr;
	}

}
