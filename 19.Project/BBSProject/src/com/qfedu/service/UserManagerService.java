package com.qfedu.service;

import com.qfedu.domain.UserExt;

public interface UserManagerService {
	public UserExt userLogin(String username,String password);
}
