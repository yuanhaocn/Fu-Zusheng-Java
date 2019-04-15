package com.syc.spring.annotation01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("service")
public class UserService {

	@Autowired
	@Qualifier("dao")
	private UserDao dao;
	
	public void register(){
		System.out.println("service...注册");
		dao.insert();
	}
}
