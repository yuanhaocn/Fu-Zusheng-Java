package com.syc.listener.bind;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

//HttpSessionBindingListener:监听某个对象是否被绑定到了session上,或者
//是否从session中解绑了.
//该监听与别的监听的区别:
//该监听类不需要注册,需要与session关联在一起.
public class User implements HttpSessionBindingListener{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//值绑定
	//HttpSessionBindingEvent:代表了session的绑定事件.
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("session--绑定了对象");
	}

	//值解绑
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("session--解绑了对象");
	}
	
	
}
