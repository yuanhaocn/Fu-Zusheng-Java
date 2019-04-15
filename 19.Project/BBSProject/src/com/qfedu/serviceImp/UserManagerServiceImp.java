package com.qfedu.serviceImp;

import com.qfedu.daoImp.UserManagerDaoImp;
import com.qfedu.domain.UserExt;
import com.qfedu.domain.UserLogin;
import com.qfedu.service.UserManagerService;

public class UserManagerServiceImp implements UserManagerService{
	private UserManagerDaoImp umdi = new UserManagerDaoImp();
	@Override
	public UserExt userLogin(String username, String password) {
		//��������
		UserLogin userLogin = new UserLogin();
		userLogin.setUsername(username);
		userLogin.setPassword(password);
		//���÷���
		UserExt userExt = umdi.selectUser(userLogin);
		return userExt;
	}

}
