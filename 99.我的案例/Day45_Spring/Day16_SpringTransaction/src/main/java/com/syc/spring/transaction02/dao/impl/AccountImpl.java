package com.syc.spring.transaction02.dao.impl;

import java.sql.SQLException;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.syc.spring.transaction02.dao.IAccoutDao;

public class AccountImpl extends JdbcDaoSupport implements IAccoutDao {

	public void out(double money, String name) throws SQLException {

		String sql = "update acount set money =money-? where name=?";

		//JdbcTemplate模板实现修改操作
		getJdbcTemplate().update(sql, money, name);
	}

	public void in(double money, String name) throws SQLException {
		String sql = "update acount set money =money+? where name=?";

		getJdbcTemplate().update(sql, money, name);
	}

}
