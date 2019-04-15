package com.qfedu.service;

import com.qfedu.domain.UserExt;

public interface UserManagerService {
	public UserExt userLogin(String username,String password);
	public int updatePass(String oldPass,String userName,String newPass) ;
	public void addPageInfo(String userName,String theme,String ingUrl,String content);
}
