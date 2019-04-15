package com.syc.spring.transaction01.service;

import java.sql.SQLException;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.syc.spring.transaction01.dao.IAccoutDao;

public class TranslateMoneyImpl implements ITranslateMoneyService {

	private IAccoutDao dao;

	// TransactionTemplate是进行事务操作的模板类,利用该类可以进行简单的事务操作.
	private TransactionTemplate template;

	public void setTemplate(TransactionTemplate template) {
		this.template = template;
	}

	public void translateMoney(final String from, final String to, final double money) {

		// 设置事务的隔离级别
		// template.setIsolationLevel(TransactionTemplate.ISOLATION_DEFAULT);

		template.execute(new TransactionCallbackWithoutResult() {

			//doInTransactionWithoutResult就是一种回调方法.
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				try {
					// session.beginTransaction();

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
					// session.rollback();
				} // finally{
					// session.commit();
					// }
			}
		});

	}

	public IAccoutDao getDao() {
		return dao;
	}

	public void setDao(IAccoutDao dao) {
		this.dao = dao;
	}

}
