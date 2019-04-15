package response.redirect;
/**
 * 本站跳转
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResponseRedirect02")
public class RedirectToInner extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("页面跳转开始。。。");
		/*
		 * 页面跳转
		 * 	站外：参数是站外站点的URL
		 *  站内：参数是当前站点的uri
		 *  重定向是两次请求，属于客户端的跳转行为
		 *  request的域就会失效，因为他只能在一次请求有效，转发是二次请求
		 */
		resp.sendRedirect("/ServletResponse/a.html");
		System.out.println("页面已经跳转了");
	}

}
