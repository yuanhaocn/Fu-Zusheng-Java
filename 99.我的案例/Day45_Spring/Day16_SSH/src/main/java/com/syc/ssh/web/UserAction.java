package com.syc.ssh.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.syc.ssh.domain.User;
import com.syc.ssh.service.IUserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;

	private User user = new User();

	public User getModel() {
		return user;
	}

	private IUserService service;

	public void setService(IUserService service) {
		this.service = service;
	}

	// 登陆方法
	public String login() {

		System.out.println("web层...登陆方法...");

		User usr = service.login(user);

		if (usr != null) {
			System.out.println("Name=" + user.getUsername());
			return SUCCESS;
		}
		return ERROR;
	}

	// 注册方法
	public String register() {

		System.out.println("web层...注册方法...");

		service.register(user);

		return SUCCESS;
	}

}
