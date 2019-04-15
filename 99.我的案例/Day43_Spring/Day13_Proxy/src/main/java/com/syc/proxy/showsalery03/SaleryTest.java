package com.syc.proxy.showsalery03;

public class SaleryTest {

	public static void main(String[] args) {
		ShowSalery target = new ShowSalery();
		Privilage privilage = new Privilage();
		privilage.setAccess("adminxxxx");
		Logger logger = new Logger();
		CheckSafe check = new CheckSafe();
		CglibShowSaleryInterceptor interceptor = new CglibShowSaleryInterceptor(target, privilage, logger, check);
		ShowSalery show = (ShowSalery) interceptor.createProxy();
		show.showSalery();
	}
}
