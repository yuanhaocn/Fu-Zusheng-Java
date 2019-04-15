package com.syc.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.syc.dao.IAdminDao;
import com.syc.entity.Admin;
import com.syc.utils.JdbcUtil;

/**
 * IAdminDao的具体实现类
 * 
 * @author 一一哥
 * @Description:
 */
public class AdminDao implements IAdminDao<Admin> {

	@Override
	public Admin login(Admin admin) {
		try {
			QueryRunner qr = JdbcUtil.getQueryRunner();
			String sql = "select * from admin where name=? and pass=?";
			return qr.query(sql, new BeanHandler<Admin>(Admin.class),
					admin.getName(), admin.getPass());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
