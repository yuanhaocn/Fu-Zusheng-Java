package com.syc.service;

import com.syc.dao.UserDao;

public class UserService {

	private UserDao dao=new UserDao();
	
	public void registerUser(){
		dao.insertUser();
	}
}
