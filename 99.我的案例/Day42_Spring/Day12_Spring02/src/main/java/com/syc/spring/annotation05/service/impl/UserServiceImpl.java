package com.syc.spring.annotation05.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.syc.spring.annotation05.dao.UserDao;
import com.syc.spring.annotation05.service.UserService;

@Service("service")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("dao")
	private UserDao dao;

	public void login() {
		System.out.println("service层代码....登陆");
		dao.findUserByNameAndPass();
	}

}
