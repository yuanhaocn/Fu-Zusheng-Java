package com.syc.spring.transaction04.web;

import com.syc.spring.transaction04.service.AccountServiceImpl;

//@Controller("web")
public class AccountAction {

	// @Autowired
	private AccountServiceImpl service;

	public void setService(AccountServiceImpl service) {
		this.service = service;
	}

	public void translateMoney() {
		service.translateMoney("张三", "李四", 100.0);
	}
}
