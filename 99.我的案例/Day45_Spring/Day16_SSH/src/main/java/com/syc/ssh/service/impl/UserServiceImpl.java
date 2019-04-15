package com.syc.ssh.service.impl;

import java.sql.SQLException;

import com.syc.ssh.dao.IUserDao;
import com.syc.ssh.domain.User;
import com.syc.ssh.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao dao;

	public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	public void register(User user) {
		try {
			System.out.println("Service层...注册方法");
			dao.insert(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User login(User user) {
		try {
			System.out.println("Service层...登陆方法");
			return dao.findByNameAndPass(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
