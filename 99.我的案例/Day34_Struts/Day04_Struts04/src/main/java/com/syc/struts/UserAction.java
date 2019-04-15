package com.syc.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 注意:如果想使用struts框架的验证功能,Action类必须继承自ActionSupport!
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;

	private User user = new User();

	// 什么地方调用了getModel()方法?
	public User getModel() {
		return user;
	}

	public String login() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("login...方法...");
		
		return "success";
	}

}
