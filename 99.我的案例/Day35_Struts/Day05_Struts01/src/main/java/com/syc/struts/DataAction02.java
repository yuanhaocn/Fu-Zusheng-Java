package com.syc.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class DataAction02 extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {

		ActionContext context = ActionContext.getContext();

		// 获取值栈的第一站方式:
		// Map<String, Object> requestMap = context.getContextMap();
		// ValueStack stack = (ValueStack) requestMap.get("struts.valueStack");

		// 获取值栈对象的第二种方式:
		ValueStack stack = context.getValueStack();
		// 存储基本的信息
		stack.push("宋江");
		stack.push(new Person("李逵", "黑铁牛",20));
		stack.push(new Person("李晨", "小黑牛",30));
		
		//set()方法,相当于是把对象存到了一个HashMap中
		stack.set("person", new Person("林冲", "豹子头",40));
		
		//弹栈的方法.
		stack.pop();
		
		//stack.size();

		return super.execute();
	}
}
