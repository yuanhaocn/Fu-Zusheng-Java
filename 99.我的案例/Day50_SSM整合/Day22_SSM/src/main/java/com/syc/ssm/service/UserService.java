package com.syc.ssm.service;

import com.syc.ssm.domain.User;

public interface UserService {

	public int registerUser(User user);
	
	public User login(User user);
}
