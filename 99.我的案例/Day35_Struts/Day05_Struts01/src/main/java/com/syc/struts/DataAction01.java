package com.syc.struts;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DataAction01 extends ActionSupport{

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {

		//1.直接利用ActionContext存值.
		ActionContext context = ActionContext.getContext();
		//ActionContext context2 = ServletActionContext.getContext();
		//ActionContext类本身就维护了一个Map<String,Object>,"大map"
		context.put("name", "武松");
		//String name = (String) context.get("name");
		
		//2.利用RequestMap存值,requestMap可以被认为是ActionContext大map里的一个"小map".
		//Map<String,Object> requestMap = (Map<String, Object>) context.get("request");
		Map<String, Object> requestMap = context.getContextMap();
		requestMap.put("requestData", "request里的数据...");
		
		//3.SessionMap
		Map<String, Object> sessionMap = context.getSession();
		sessionMap.put("sessionData", "session里的数据");
		
		//4.applicationMap
		Map<String, Object> applicationMap = context.getApplication();
		applicationMap.put("applicationData", "application里的数据");
		
		return super.execute();
	}
}
