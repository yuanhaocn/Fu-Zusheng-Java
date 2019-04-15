package com.syc.manager.dao;

import com.syc.manager.domain.User;

public interface UserMapper {
	
	User findUserByUserName(String username);
}
