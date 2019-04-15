package com.syc.spring.transaction04.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.syc.spring.transaction04.dao.AccountDaoImpl;

/*
 * 业务代码层.
 * 转账业务在该类中实现.
 */
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
// @Service
public class AccountServiceImpl {

	// @Autowired
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
