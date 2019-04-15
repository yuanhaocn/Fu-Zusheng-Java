package com.qfedu.dao;

import com.qfedu.domain.PageInfo;
import com.qfedu.domain.UserExt;
import com.qfedu.domain.UserLogin;

public interface UserManagerDao {
	//��¼
	public UserExt selectUser(UserLogin userLogin);
	public int insertNewPass(UserLogin userLogin) ;
	public void InsertPageInfo(PageInfo pageInfo);
}
