package com.syc.spring.transaction02.web;

import com.syc.spring.transaction02.service.ITranslateMoneyService;

public class TranslateAction {

	private ITranslateMoneyService service;

	public ITranslateMoneyService getService() {
		return service;
	}

	public void setService(ITranslateMoneyService service) {
		this.service = service;
	}

	public void translate(){
		service.translateMoney("张三", "李四", 100);
	}
}
