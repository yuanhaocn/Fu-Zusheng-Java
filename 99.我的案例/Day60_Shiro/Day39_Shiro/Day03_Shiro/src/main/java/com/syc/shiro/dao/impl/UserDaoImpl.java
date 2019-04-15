package com.syc.shiro.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.syc.shiro.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	@Qualifier("factory")
	private SessionFactory factory;

	public Object findObject(String hql, Object[] args) {
		Session session = factory.openSession();
		Query query = session.createQuery(hql);
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}
		Object obj = query.uniqueResult();
		session.close();
		return obj;
	}

	@SuppressWarnings("unchecked")
	public List<Object> findAll(String hql, Object[] args) {
		Session session = factory.openSession();
		Query query = session.createQuery(hql);
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}
		List<Object> list = query.list();
		session.close();
		return list;
	}

}
