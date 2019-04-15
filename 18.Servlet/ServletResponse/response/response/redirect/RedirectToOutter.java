package response.redirect;
/**
转发和重定向的区别
	1.地址栏
		转发地址栏不变，重定向的地址栏发生改变
	2.速度
		转发的速度快，重定向速度慢
	3.范围
		转发只可以在当前项目里面转发，可以转发很多次
		重定向允许往其他项目中重定向，也可以重定向很多次
	4.参数
		转发参数是servletPath，重定向对于站外是完整的URL
		对于本站是URI
	5.请求次数
		转发是一次请求，属于服务器内部跳转
		重定向是两次请求，属于客户端跳转
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResponseRedirect")
public class RedirectToOutter extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("页面跳转开始。。。");
		/*
		 * 页面跳转
		 * 	站外：参数是站外站点的URL
		 *  站内：参数是当前站点的uri
		 */
		resp.sendRedirect("http://www.baidu.com");
		System.out.println("页面已经跳转了");
	}

}
