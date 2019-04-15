package com.syc.spring.transaction01.service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.syc.spring.transaction01.dao.AccountDaoImpl;

/*
 * 业务代码层.
 * 转账业务在该类中实现.
 */
public class AccountServiceImpl {

	private AccountDaoImpl dao;

	public void setDao(AccountDaoImpl dao) {
		this.dao = dao;
	}

	// 事务模板类
	private TransactionTemplate transaction;

	public void setTransaction(TransactionTemplate transaction) {
		this.transaction = transaction;
	}

	public void translateMoney(final String fromName, final String toName, final double money) {

		//把要执行的业务代码,放到该方法,就可以自动实现事务.
		transaction.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				dao.subMoney(money, fromName);

				int i = 10 / 0;

				System.out.println("i=" + i);

				dao.addMoney(money, toName);
			}
		});

	}
}
