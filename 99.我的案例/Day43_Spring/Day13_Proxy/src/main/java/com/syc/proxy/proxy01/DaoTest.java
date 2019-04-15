package com.syc.proxy.proxy01;

import java.lang.reflect.Proxy;

public class DaoTest {

	public static void main(String[] args) {
		
		UserDaoImpl target=new UserDaoImpl();
		Class<? extends UserDaoImpl> clazz = target.getClass();
		Transaction transaction=new Transaction();
		DaoHandler handler=new DaoHandler(target, transaction);
		
		UserDao dao = (UserDao) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), handler);
		
		//dao.insert();
		dao.update();
		//dao.query();
	}
}
