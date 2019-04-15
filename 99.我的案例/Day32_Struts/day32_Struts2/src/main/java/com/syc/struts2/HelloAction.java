package com.syc.struts2;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 创建一个Action类,取代之前的Servlet
 * 
 * @类名称:HelloAction
 * @创建人:SYC
 * @创建时间:2017年8月11日 上午11:12:21
 */
public class HelloAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	// Action中方法的特点!
	// 1.修饰符是public;
	// 2.返回值是String;
	// 3.该方法没有参数!
	@Override
	public String execute() throws Exception {

		// return super.execute();
		// return SUCCESS;
		return "success";
	}
}
