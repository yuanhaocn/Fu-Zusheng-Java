package com.syc.struts.data05;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class DataAction {

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String showData() {

		System.out.println("username=" + username);

		//第一种传值方式:ActionContext.getContext()里面的方法.
		//ActionContext context = ActionContext.getContext();
		//Map<String, Object> requestMap = context.getContextMap();
		//requestMap.put("name", username);
		
		//第二种传值方式:
		//ActionContext context = ServletActionContext.getContext();
		//HttpServletResponse response = ServletActionContext.getResponse();
		//ServletContext application = ServletActionContext.getServletContext();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("name", username);
		
		return "success";
	}
}
