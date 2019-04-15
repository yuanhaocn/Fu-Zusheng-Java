package com.syc.struts;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction {

	// 必须提供与jsp表单中的name值一样的属性名称,并且必须提供setXXX()方法.
	// private String username;
	// private String password;
	// public void setUsername(String username) {
	// this.username = username;
	// }
	//
	// public void setPassword(String password) {
	// this.password = password;
	// }

	// 注意:定义了User对象.
	//jsp表单中的name属性值应该与本属性名称一致!
	private User user = new User();

	//必须有get方法(),否则会导致password=null!
	public void getUser()(){
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login() {

		// System.out.println("Name=" + username + ",Pass=" + password);

		System.out.println("Name=" + user.getUsername() + ",Pass=" + user.getPassword());

		//Action给JSP传值:要把这些值存起来.
		//获取一个ActionContext对象
		ActionContext context = ActionContext.getContext();
		//对应request域
		Map<String, Object> requestMap = context.getContextMap();
		//对应session域
		Map<String, Object> sessionMap = context.getSession();
		//对应application域
		Map<String, Object> applicationMap = context.getApplication();
		
		//把信息存到了request域中
		requestMap.put("requestName", user.getUsername());
		
		//把信息存到了session域中
		sessionMap.put("sessionName", user.getUsername());
		
		//把信息存到了application域中
		applicationMap.put("applicationName", user.getUsername());
		
		return "success";
	}
}
