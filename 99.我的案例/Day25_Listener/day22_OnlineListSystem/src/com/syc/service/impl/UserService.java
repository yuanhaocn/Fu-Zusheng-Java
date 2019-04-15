package com.syc.service.impl;

import java.util.List;

import com.syc.dao.IUserDao;
import com.syc.dao.impl.UserDao;
import com.syc.entity.User;
import com.syc.service.IUserService;

/**
 * Service层调用Dao层,实现用户信息查询
 * 
 * @author 一一哥
 * @Description:
 */
public class UserService implements IUserService<User> {

	private IUserDao<User> dao = new UserDao();

	@Override
	public List<User> findUsers() {
		try {
			return dao.findUsers();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
