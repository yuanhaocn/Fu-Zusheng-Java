package com.syc.listener.attribute;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

//监听ServletContext属性值的变化
public class ContextAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		System.out.println("context-attribute-add");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("context-attribute-remove");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("context-attribute-replace");
	}

}
