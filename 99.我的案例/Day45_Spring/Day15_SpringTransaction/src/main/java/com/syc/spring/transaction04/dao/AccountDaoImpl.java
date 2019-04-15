package com.syc.spring.transaction04.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

//@Repository
public class AccountDaoImpl extends JdbcDaoSupport {

	// 减钱
	public void subMoney(double money, String name) {
		String sql = "update acount set money=money-? where name=?";
		getJdbcTemplate().update(sql, money, name);
	}

	// 加钱
	public void addMoney(double money, String name) {
		String sql = "update acount set money=money+? where name=?";
		getJdbcTemplate().update(sql, money, name);
	}
}
