package com.syc.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory factory;

	// 保证SessionFactory对象,随着该类的加载而创建.
	static {
		Configuration cfg = new Configuration();
		cfg.configure();
		factory = cfg.buildSessionFactory();
	}

	public static Session openSession() {
		if (factory != null) {
			return factory.openSession();
		}
		return null;
	}

}
