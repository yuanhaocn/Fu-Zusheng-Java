package com.syc.spring.transaction03.service.impl;

import java.sql.SQLException;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.syc.spring.transaction03.dao.IAccoutDao;
import com.syc.spring.transaction03.service.ITranslateMoneyService;

/*
 * 事务传播行为:
 * Propagation.REQUIRED:如果当前类中有事务则用当前事务,没有事务则开启一个新的事务;
 * Propagation.REQUIRES_NEW:无论当前是否存在事务,则一律创建一个新事物;
 * Propagation.MANDATORY:如果当前类中有事务则用当前事务,如果没有事务则会抛出异常;
 * Propagation.SUPPORTS:如果当前有事务则使用事务,如果没有则在无事务的状态下运行.
 * Propagation.NOT_SUPPORTED:不支持事务的使用,总是在无事务的状态下执行;
 * Propagation.NESTED:在嵌套的事务中执行;
 * Propagation.NEVER:不支持事务的使用,如果存在事务则会抛出异常;
 */
@Transactional(propagation=Propagation.REQUIRED,
	isolation=Isolation.DEFAULT)
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
