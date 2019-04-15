package com.syc.shiro.service;

import java.util.List;

import com.syc.shiro.domain.User;

public interface UserService {

	User findUserByName(String username);
	
	List<String> findRolesByName(String username);
	
	
	List<String> findPermissionsByName(String username);
}
