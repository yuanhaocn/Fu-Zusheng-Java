package com.syc.listener;

import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.syc.entity.Admin;

/**
 * 在线用户列表集合监听器.
 * 服务器启动时开始监听;
 * 服务器关闭时停止监听;
 * 当服务器一启动,就创建一个集合,存放当前在线用户.
 * @author 一一哥        
 * @Description:
 */
public class OnLineUserListListener implements ServletContextListener {

	//服务器启动时就构建"onLineList"集合.
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//List集合,可以多次存放同一个类的对象,会导致同一个用户同时多次登陆的问题?
		//List<Admin> onLineList=new ArrayList<Admin>();
		//线程安全的集合,解决集合遍历时无法增删改的问题.
		CopyOnWriteArrayList<Admin> onLineList=new CopyOnWriteArrayList<Admin>();
		sce.getServletContext().setAttribute("onLineList", onLineList);
	}

	//服务器停止时就销毁"onLineList"集合.
	@SuppressWarnings("unchecked")
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//ArrayList<Admin> onLineList = (ArrayList<Admin>) sce.getServletContext().getAttribute("onLineList");
		CopyOnWriteArrayList<Admin> onLineList = (CopyOnWriteArrayList<Admin>) sce.getServletContext().getAttribute("onLineList");
		if(onLineList!=null){
			//将在线用户列表集合从ServletContext域中移除.
			sce.getServletContext().removeAttribute("onLineList");
			onLineList=null;
		}
	}

}
