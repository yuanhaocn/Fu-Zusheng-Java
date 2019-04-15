package com.syc.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建和设置Cookie
 */
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 创建Cookie
		Cookie nameCk = new Cookie("name", "syc");
		Cookie emailCk = new Cookie("email", "syc@126.com");

		// 正数:该cookie的生命周期是1000秒.也就是说在一个会话结束后,该Cookie存活1000秒.
		// 会持久化保存,也就是浏览器会专门为该Cookie创建一个文本文件.
		// 0:删除某个已有的Cookie
		// 负数:默认是-1,表示会话结束后,该Cookie立马失效.在这种情况下,Cookie只保存在内存中,
		// 而不会持久化保存.
		nameCk.setMaxAge(1000);
		
		//http://www.baidu.com/index.html
		//.baidu.com 一级域名
		//www.baidu.com 二级域名
		//news.baidu.com 二级域名
		//tieba.baidu.com 二级域名
		// /index.html 资源path
		
		//http://localhost:8080/day18_Cookie/cookie
		//http://localhost:8080/day18_Cookie/getCookie
		//http://localhost:8080/day19_Cookie/getCookie
		
		//Cookie的path属性:
		//如果默认不设置path,默认的path是当前项目路径--->/day18_Cookie.
		//也就是说设置的是哪个path,读取的时候只能读取哪个path下的cookie.
		//以此来提高cookie的访问安全性.
		nameCk.setPath("/day18_Cookie");
		//emailCk.setPath("/day19_Cookie");
		
		//Cookie的domain(域名),域名必须完全一致时才能互相访问cookie.
		//nameCk.setDomain("tieba.baidu.com");
		//emailCk.setDomain("news.baiduc.com");

		// Servlet添加一个Cookie
		response.addCookie(nameCk);
		response.addCookie(emailCk);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
