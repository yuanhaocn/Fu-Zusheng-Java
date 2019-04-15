package com.syc.struts.action;

import com.opensymphony.xwork2.ActionSupport;

public class I18NAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String showMsg() {

		//第一种实现方式:javaee自身的API方法.
		// 本地化对象
		// 本地化代表了当前用户所使用的国家和语言
		// Locale locale = Locale.getDefault();
		// Locale locale=Locale.US;
		// ResourceBundle bundle =
		// ResourceBundle.getBundle("com.syc.struts.resource.msg", locale);
		// String login = bundle.getString("login");
		// String title = bundle.getString("title");
		// String username = bundle.getString("username");
		// String password = bundle.getString("password");

		// 第二种实现方式:简化写法.
		//前提:必须继承ActionSupport,还必须配置constant常量.
		String login = getText("login");
		String title = getText("title");
		String username = getText("username");
		String password = getText("password");

		System.out.println("Login=" + login);
		System.out.println("title=" + title);
		System.out.println("username=" + username);
		System.out.println("password=" + password);

		return "success";
	}
}
