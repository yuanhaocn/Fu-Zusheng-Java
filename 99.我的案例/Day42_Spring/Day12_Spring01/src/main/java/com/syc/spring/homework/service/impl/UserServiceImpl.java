package com.syc.spring.homework.service.impl;

import com.syc.spring.homework.dao.UserDao;
import com.syc.spring.homework.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao dao;

	//来实现注入值!
	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	public void login() {
		System.out.println("service层代码....登陆");
		dao.findUserByNameAndPass();
	}

}
