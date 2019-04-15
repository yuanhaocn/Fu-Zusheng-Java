package com.syc.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 记录用户的上次上次访问时间
 */
public class LastVisitTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		// 思路:
		// ①.如果是第一次访问:创建cookie,并且把当前访问时间存起来;
		// ②.如果不是第一次访问:查找cookie,取出cookie中存储的信息,进行展示;把第二...次新的访问时间覆盖原有的访问时间.

		//IllegalArgumentException: An invalid character [32] was present in the Cookie value.
		//Cookie中不允许出现特殊的字符----比如空格, 逗号等
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		// 当前时间
		String currentTime = format.format(new Date());

		PrintWriter writer = response.getWriter();

		// 上次访问时间
		String lastTime = null;

		// 取出存储的Cookie信息
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				// 判断是否是想要的cookie
				if ("lastVisitTime".equals(name)) {
					// 上次访问时间
					lastTime = cookie.getValue();
					writer.write("您的上次访问时间是:" + lastTime);
					// Cookie cookie=new Cookie("lastVisitTime", currentTime);
					cookie.setValue(currentTime);
					response.addCookie(cookie);
					break;
				}
			}
		}

		// 如果是第一次访问的时候:
		if (cookies == null || lastTime == null) {
			Cookie cookie = new Cookie("lastVisitTime", currentTime);
			//设置Cookie的生命周期
			//cookie.setMaxAge(Integer.MAX_VALUE);
			cookie.setMaxAge(30*24*60*60);//一个月
			response.addCookie(cookie);
			writer.write("你好,这是你第一次访问!");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
