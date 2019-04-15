package com.syc.struts;

import com.opensymphony.xwork2.Action;

/**
 * 创建Action的第二种方式,通过实现Action接口来完成.
 * @类名称:SecondAction
 * @创建人:SYC
 * @创建时间:2017年8月11日 下午2:28:46
 */
public class SecondAction implements Action {

	public String execute() throws Exception {
		//SUCCESS,LOGIN,ERROR,INPUT,NONE
		return SUCCESS;
	}

	public String login(){
		
		return LOGIN;
	}
}
