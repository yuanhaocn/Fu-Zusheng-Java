package com.syc.layer.service.impl;

import java.sql.SQLException;

import com.syc.layer.dao.IUserDao;
import com.syc.layer.dao.impl.UserDaoImpl;
import com.syc.layer.domain.User;
import com.syc.layer.service.ILoginService;

/**
 * 业务逻辑层的具体实现
 * @类名称:LoginServiceImpl
 * @创建人:SYC
 * @创建时间:2017年7月31日 上午11:49:36
 */
public class LoginServiceImpl implements ILoginService{

	//在service层调用dao层
	private IUserDao dao=new UserDaoImpl();
	
	@Override
	public User login(User user) {
		try {
			return dao.findUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void register(User user) {
		try {
			dao.addUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
