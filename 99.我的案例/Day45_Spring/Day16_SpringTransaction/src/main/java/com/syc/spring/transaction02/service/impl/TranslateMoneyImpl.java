package com.syc.spring.transaction02.service.impl;

import java.sql.SQLException;

import com.syc.spring.transaction02.dao.IAccoutDao;
import com.syc.spring.transaction02.service.ITranslateMoneyService;

public class TranslateMoneyImpl implements ITranslateMoneyService {

	private IAccoutDao dao;

	// 执行事务的方法
	public void translateMoney(String from, String to, double money) {
		try {
			// 核对账户
			// 核对账户余额
			// 其他的操作

			// 先减钱
			dao.out(money, from);

			// 其他的操作----产生了异常!
			int i = 10 / 0;
			System.out.println("结果=" + i);

			// 再加钱
			dao.in(money, to);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public IAccoutDao getDao() {
		return dao;
	}

	public void setDao(IAccoutDao dao) {
		this.dao = dao;
	}

}
