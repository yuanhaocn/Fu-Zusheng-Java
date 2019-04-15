package com.syc.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 创建Session,利用Session传值.
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		// Cookie ck=new Cookie(name,value);

		// getSession():创建或获取一个HttpSession对象.
		HttpSession session = request.getSession();
		//获取一个HttpSession对象.该方法只会获取一个已有的session对象,而不会创建.
		//HttpSession session = request.getSession(false);

		// 只要服务器端创建了一个Session对象,然后在浏览器中请求该页面的时候,浏览器就会自动
		// 创建一个与之对应的Cookie对象.那么这个Cookie是用来保存Session的ID的.
		// 这个Cookie有个名字叫JSSESSIONID=.....
		// 因为每个Session都有一个唯一的编号.

		String id = session.getId();
		long creationTime = session.getCreationTime();
		long lastAccessedTime = session.getLastAccessedTime();
		System.out.println("ID=" + id + ",创建时间:" + creationTime + ",上次访问时间:" + lastAccessedTime);

		//设置Session自身的生命周期,单位是秒.
		session.setMaxInactiveInterval(20);
		
		session.setAttribute("name", "syc");

		//创建JSESSIONID.起始是覆盖了浏览器为session自动产生的Cookie
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(60);
		response.addCookie(cookie);

		response.getWriter().write("ID=" + id + ",创建时间:" + creationTime + ",上次访问时间:" + lastAccessedTime);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
