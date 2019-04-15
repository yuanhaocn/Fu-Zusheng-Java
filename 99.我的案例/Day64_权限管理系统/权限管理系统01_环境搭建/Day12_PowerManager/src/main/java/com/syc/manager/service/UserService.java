package com.syc.manager.service;

import com.syc.manager.domain.User;

public interface UserService {

	User findUserByUserName(String username);
}
