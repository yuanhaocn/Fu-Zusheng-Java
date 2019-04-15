package com.syc.service.impl;

import com.syc.dao.IAdminDao;
import com.syc.dao.impl.AdminDao;
import com.syc.entity.Admin;
import com.syc.service.IAdminService;

/**
 * Service层,调用Dao层,实现管理员登陆功能
 * 
 * @author 一一哥
 * @Description:
 */
public class AdminService implements IAdminService<Admin> {

	IAdminDao<Admin> dao = new AdminDao();

	@Override
	public Admin login(Admin admin) {
		return dao.login(admin);
	}

}
