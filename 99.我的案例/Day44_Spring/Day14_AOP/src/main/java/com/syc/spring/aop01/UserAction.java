package com.syc.spring.aop01;

public class UserAction {

	private UserService service;

	public void setService(UserService service) {
		this.service = service;
	}

	public void register() {
		System.out.println("web....注册");
		service.register();
	}
}
