package com.syc.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 修改,删除Cookie
 */
public class DeleteCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//修改Cookie.要想修改某个已有的Cookie,只需要把原有cookie的值给覆盖掉即可.
		//也就是name的值相同,value不同即可.
		//Cookie cookie=new Cookie("email", "syc@163.com");
		//response.addCookie(cookie);
		
		//删除Cookie.
		Cookie cookie=new Cookie("email", "");
		//age为0,就要删除该Cookie.
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
