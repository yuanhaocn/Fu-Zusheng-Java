package com.syc.struts;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 创建Action的第一种方式
 * @类名称:FirstAction
 * @创建人:SYC
 * @创建时间:2017年8月11日 下午2:11:08
 */
public class FirstAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {

		return ERROR;
	}

	//Action中定义的要被执行的方法:
	//1.public;
	//2.String返回值;
	//3.无参数.
	public String firstMethod(){
		return "first";
	}
	
}
