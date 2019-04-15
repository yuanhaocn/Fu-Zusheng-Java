package com.syc.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DataAction03 extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {

		//el表达式,根据key获取对应值的顺序:
		//Request,ValueStack,ActionContext,Session,Application
		
		//ActionContext context = ActionContext.getContext();
		//context.put("name", "鲁智深");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("name", "鲁智深");
		
		return super.execute();
	}
}
