package com.syc.struts;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;

	private User user = new User();

	public User getModel() {

		return user;
	}

	// 处理登陆请求
	public String login() {

		String username = user.getUsername();
		String password = user.getPassword();

		if ("syc".equals(username) && "123".equals(password)) {
			//登陆成功
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("user", user);
			
			return SUCCESS;
		}

		return INPUT;
	}
	
	//处理退出的请求
	public String logout(){
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		//session.removeAttribute("user");
		session.invalidate();
		
		return INPUT;
	}

}
