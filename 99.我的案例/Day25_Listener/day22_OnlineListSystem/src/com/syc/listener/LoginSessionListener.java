package com.syc.listener;

import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.syc.entity.Admin;

/**
 * HttpSessionAttributeListener:监听Session中属性值的变化.
 * @类名称:LoginSessionListener
 * @创建人:SYC
 * @创建时间:2017年7月28日 下午5:29:47
 */
public class LoginSessionListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
	}

	//当session中属性值被移除的时候,获取ServletContext对象中的onLineList集合.
	//从这个集合中将session中被移除的属性值给删除掉.
	@SuppressWarnings("unchecked")
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		Object value = se.getValue();
		if (value != null) {
			ServletContext context = se.getSession().getServletContext();
			//List<Admin> onlineList = (List<Admin>) context.getAttribute("onLineList");
			CopyOnWriteArrayList<Admin> onlineList = (CopyOnWriteArrayList<Admin>) context.getAttribute("onLineList");
			boolean remove = onlineList.remove(value);
			System.out.println("移除结果=" + remove);
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {

	}

}
