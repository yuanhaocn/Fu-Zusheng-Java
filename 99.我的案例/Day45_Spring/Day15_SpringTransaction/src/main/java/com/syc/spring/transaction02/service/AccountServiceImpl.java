package com.syc.spring.transaction02.service;

import com.syc.spring.transaction02.dao.AccountDaoImpl;

/*
 * 业务代码层.
 * 转账业务在该类中实现.
 */
public class AccountServiceImpl {

	private AccountDaoImpl dao;

	public void setDao(AccountDaoImpl dao) {
		this.dao = dao;
	}

	// 主要的业务方法
	public void translateMoney(final String fromName, final String toName, final double money) {

		dao.subMoney(money, fromName);

		int i = 10 / 0;

		System.out.println("i=" + i);

		dao.addMoney(money, toName);

	}
}
