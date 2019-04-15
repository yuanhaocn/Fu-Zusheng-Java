package com.syc.proxy.cglib02;

public class DaoTest {

	public static void main(String[] args) {
		UserDaoImpl target=new UserDaoImpl();
		Transaction transaction=new Transaction();
		DaoInterceptor interceptor=new DaoInterceptor(target, transaction);
		UserDaoImpl impl= (UserDaoImpl) interceptor.createProxy();
		impl.delete();
		//impl.query();
	}
}
