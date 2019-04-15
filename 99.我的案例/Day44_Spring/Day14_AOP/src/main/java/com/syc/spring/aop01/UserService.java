package com.syc.spring.aop01;

public class UserService {

	private UserDao dao;

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	public void register() {
		System.out.println("service...注册...");
		dao.insert();
	}
}
