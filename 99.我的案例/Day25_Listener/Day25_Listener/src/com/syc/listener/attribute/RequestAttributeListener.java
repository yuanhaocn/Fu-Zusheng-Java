package com.syc.listener.attribute;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

//监听ServletRequest对象中属性的添加,移除,和替换.
public class RequestAttributeListener implements ServletRequestAttributeListener {

	// ServletRequestAttributeEvent:用来通知属性发生改变的事件.
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("request-attribute-add");
		// 获取属性名称
		String name = srae.getName();
		// 获取属性值
		Object value = srae.getValue();
		System.out.println("add--" + name + "--" + value);
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("request-attribute-remove");
		// 获取属性名称
		String name = srae.getName();
		// 获取属性值
		Object value = srae.getValue();
		System.out.println("remove--" + name + "--" + value);
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("request-attribute-replace");
		// 获取属性名称
		String name = srae.getName();
		// 获取属性值
		Object value = srae.getValue();
		System.out.println("replace--" + name + "--" + value);
	}

}
