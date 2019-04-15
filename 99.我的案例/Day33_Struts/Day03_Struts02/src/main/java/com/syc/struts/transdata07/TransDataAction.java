package com.syc.struts.transdata07;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class TransDataAction implements 
	RequestAware, SessionAware, ApplicationAware {

	private Map<String, Object> requestMap;
	private Map<String, Object> sessionMap;
	private Map<String, Object> applicationMap;

	// request:request域里的map
	public void setRequest(Map<String, Object> request) {
		this.requestMap = request;
	}

	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}

	public void setApplication(Map<String, Object> application) {
		this.applicationMap = application;
	}

	public String transData() {
		// requestMap.put("name", "request域中的信息");
		//sessionMap.put("name", "session域中的信息");
		applicationMap.put("name", "application域中的信息");
		return "success";
	}

}
