package com.syc.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;

/*
 * ModelDriven:模型驱动.
 * 通过ModelDriven,将User对象压入到值栈(该值栈是UserAction类本身就自带的)里去
 */
public class UserAction implements ModelDriven<User>{

	private User user=new User();
	
	//返回一个User对象.
	//从Action类内部的值栈中把User对象获取出来.
	public User getModel() {

		return user;
	}
	
	public String register(){
		
		System.out.println("用户名:"+user.getUsername()+",密码:"+user.getPassword());
		
		//传值
		//Map<String, Object> contextMap = ActionContext.getContext().getContextMap();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("user", user);
		
		return "success";
	}

}
