package com.qfedu.serviceImp;

import com.qfedu.daoImp.UserManagerDaoImp;
import com.qfedu.domain.PageInfo;
import com.qfedu.domain.UserExt;
import com.qfedu.domain.UserLogin;
import com.qfedu.service.UserManagerService;

public class UserManagerServiceImp implements UserManagerService {
	private UserManagerDaoImp umdi = new UserManagerDaoImp();

	@Override
	public UserExt userLogin(String username, String password) {
		// 构建对象
		UserLogin userLogin = new UserLogin();
		userLogin.setUsername(username);
		userLogin.setPassword(password);
		// 调用方法
		UserExt userExt = umdi.selectUser(userLogin);
		return userExt;
	}

	@Override
	public int updatePass(String oldPass,String userName, String newPass) {
			UserLogin userNewPass = new UserLogin();
			userNewPass.setNewPassword(newPass);
			userNewPass.setPassword(oldPass);
			userNewPass.setUsername(userName);
			int insertNewPass = umdi.insertNewPass(userNewPass);
			return insertNewPass;
	}

	@Override
	public void addPageInfo(String userName, String theme, String ingUrl, String content) {
		 PageInfo pageInfo = new PageInfo();
		 pageInfo.setSendUser(userName);
		 pageInfo.setTheme(theme);
		 pageInfo.setSendContent(content);
		 pageInfo.setPhoto(ingUrl);
		 umdi.InsertPageInfo(pageInfo);
	}
	

}
