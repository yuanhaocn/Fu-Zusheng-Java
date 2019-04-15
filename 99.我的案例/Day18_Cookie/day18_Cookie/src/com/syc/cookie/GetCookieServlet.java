package com.syc.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取Cookie信息
 */
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();

		//http://localhost:8080/day18_Cookie/getCookie
		
		StringBuffer msg = new StringBuffer();
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
				int maxAge = cookie.getMaxAge();
				System.out.println("name="+name+",value="+value);
				msg.append("name=" + name).append(",value=" + value).append(",age=" + maxAge);
			}
		}else{
			msg.append("Cookie为空!");
		}
		
		writer.write(msg.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
