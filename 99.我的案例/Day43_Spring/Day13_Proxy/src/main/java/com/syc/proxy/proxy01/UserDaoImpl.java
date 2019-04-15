package com.syc.proxy.proxy01;

/*
 * 目标类
 * 目标类中的方法,可以被称为目标方法.
 */
public class UserDaoImpl implements UserDao {

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
