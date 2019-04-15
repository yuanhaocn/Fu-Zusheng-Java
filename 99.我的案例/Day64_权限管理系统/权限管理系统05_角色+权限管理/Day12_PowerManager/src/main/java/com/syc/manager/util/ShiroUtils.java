package com.syc.manager.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.syc.manager.domain.User;

/**
 * Shiro工具类
 * 
 * @创建人:一一哥
 */
public class ShiroUtils {

	/**
	 * 获取Session对象
	 */
	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	/**
	 * 获取Subject对象
	 */
	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	/**
	 * 获取身份对象
	 */
	public static User getUser() {
		return (User) SecurityUtils.getSubject().getPrincipal();
	}

	/**
	 * 获取UserName
	 */
	public static String getUserName() {
		return getUser().getUsername();
	}

	/**
	 * 存值
	 */
	public static void setSessionAttribute(Object key, Object value) {
		getSession().setAttribute(key, value);
	}

	/**
	 * 取值
	 */
	public static Object getSessionAttribute(Object key) {
		return getSession().getAttribute(key);
	}

	/**
	 * 判断是否登录了
	 */
	public static boolean isLogin() {
		return SecurityUtils.getSubject().getPrincipal() != null;
	}

	/**
	 * 判断是否退出了
	 */
	public static void logout() {
		SecurityUtils.getSubject().logout();
	}
}
