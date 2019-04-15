package com.syc.proxy.cglib02;

/*
 * 目标类
 * 目标类中的方法,可以被称为目标方法.
 * Cglib代理,也被称为子代理模式.
 * 特点:
 * 有一个子类继承了父类(目标类),会以父类为模板创建一个代理对象.
 * 无论是目标类还是代理类,都不必要实现一个接口,也就是说接口是可有可无的!
 * cglib代理与动态代理的区别:
 * 1.cglib代理中目标类不需要实现接口,动态代理中目标类必须实现接口;
 * 2.cglib代理中必须指明以目标类作为父类,hancer.setSuperClass(目标类的字节码); 
 * 
 */
public class UserDaoImpl  {

	public void insert() {
		System.out.println("数据添加....insert");
	}

	public void delete() {
		System.out.println("数据删除....delete");
	}

	public void update() {
		System.out.println("数据修改....update");
	}

	public void query() {
		System.out.println("数据查询....query");
	}

}
