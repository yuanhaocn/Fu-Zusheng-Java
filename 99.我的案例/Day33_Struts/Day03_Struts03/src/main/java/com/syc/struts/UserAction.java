package com.syc.struts;

import java.text.SimpleDateFormat;

public class UserAction {

	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String register() {

		System.out.println("用户名:" + user.getUsername());
		System.out.println("密码:" + user.getPassword());
		System.out.println("性别:" + user.getSex());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("年月:" + format.format(user.getBirthday()));

		return "success";
	}
}
