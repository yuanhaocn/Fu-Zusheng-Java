package com.syc.ssm.service;

import com.syc.ssm.domain.Users;

public interface UserService {

	public int registerUser(Users user);
	
	public Users login(Users user);
}
