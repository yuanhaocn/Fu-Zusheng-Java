package com.syc.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.manager.dao.UserMapper;
import com.syc.manager.domain.User;
import com.syc.manager.service.UserService;
import com.syc.manager.util.MyLog;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findUserByUserName(String username) {
		MyLog.log("userservice---->"+username);
		return userMapper.findUserByUserName(username);
	}

}
