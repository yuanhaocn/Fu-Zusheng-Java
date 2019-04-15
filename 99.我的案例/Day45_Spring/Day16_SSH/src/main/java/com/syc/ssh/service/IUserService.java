package com.syc.ssh.service;

import com.syc.ssh.domain.User;

public interface IUserService {

	public void register(User user);
	
	public User login(User user);
}
