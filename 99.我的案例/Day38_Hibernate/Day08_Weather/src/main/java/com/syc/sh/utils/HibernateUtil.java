package com.syc.sh.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory factory;

	static {
		Configuration cfg = new Configuration();
		cfg.configure();
		factory = cfg.buildSessionFactory();

		// 在虚拟机关闭的时候,关闭SessionFactory
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				factory.close();
			}
		}));
	}
	
	public static Session openSession(){
		if(factory!=null){
			return factory.openSession();
		}
		return null;
	}
}
