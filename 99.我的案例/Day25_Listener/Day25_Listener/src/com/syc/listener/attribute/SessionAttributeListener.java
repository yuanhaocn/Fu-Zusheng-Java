package com.syc.listener.attribute;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

//监听session值变化的监听器
public class SessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("session-attribute-add");
		// 获取属性名称
		String name = se.getName();
		// 获取属性值
		Object value = se.getValue();
		System.out.println("add--" + name + "--" + value);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("session-attribute-remove");
		// 获取属性名称
		String name = se.getName();
		// 获取属性值
		Object value = se.getValue();
		System.out.println("remove--" + name + "--" + value);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("session-attribute-replace");
		// 获取属性名称
		String name = se.getName();
		// 获取属性值
		Object value = se.getValue();
		System.out.println("replace--" + name + "--" + value);
	}

}
