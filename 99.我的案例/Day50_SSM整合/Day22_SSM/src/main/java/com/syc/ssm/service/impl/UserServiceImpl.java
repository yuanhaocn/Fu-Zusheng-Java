package com.syc.ssm.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.syc.ssm.dao.UserDao;
import com.syc.ssm.domain.User;
import com.syc.ssm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	@Qualifier("userDao")
	private UserDao dao;
	
	public int registerUser(User user) {
		try {
			return dao.insertUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public User login(User user) {
		try {
			return dao.selectByNameAndPass(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
