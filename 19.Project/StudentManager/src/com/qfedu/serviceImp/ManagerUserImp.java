package com.qfedu.serviceImp;

import com.qfedu.dao.UserHandle;
import com.qfedu.domain.User;
import com.qfedu.service.ManagerUser;

public class ManagerUserImp implements ManagerUser{
	private UserHandle uh;
	
	@Override
	public boolean login(String number, String password) {
		User user = new User();
		user.setNumber(number);
		user.setPassword(password);
		boolean b = uh.selectUserByUsername(user);
		return b;
	}

	public UserHandle getUh() {
		return uh;
	}

	public void setUh(UserHandle uh) {
		this.uh = uh;
	}

}
