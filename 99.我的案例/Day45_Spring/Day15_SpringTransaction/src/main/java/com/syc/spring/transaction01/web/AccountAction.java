package com.syc.spring.transaction01.web;

import com.syc.spring.transaction01.service.AccountServiceImpl;

public class AccountAction {

	private AccountServiceImpl service;

	public void setService(AccountServiceImpl service) {
		this.service = service;
	}

	public void translateMoney() {
		service.translateMoney("张三", "李四", 100.0);
	}
}
