package com.syc.spring.transaction02.service;

/*
 * 业务层代码,实现具体的转账业务
 */
public interface ITranslateMoneyService {

	public void translateMoney(String from,String to,double money);
}
