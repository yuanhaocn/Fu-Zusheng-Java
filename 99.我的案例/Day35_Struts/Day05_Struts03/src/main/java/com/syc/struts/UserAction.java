package com.syc.struts;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	public String hello(){
		
		System.out.println("UserAction执行了...");
		
		return SUCCESS;
	}
}
