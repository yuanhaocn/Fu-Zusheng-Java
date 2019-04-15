package c$ContextDispatcher;
/**
 * 	页面交互（跳转）--》从servlet到html:servlet用来做数据的处理,html用来做数据的展示
 * 先用浏览器启动dispatcher04的servlet应用，就会自动显示跳转的show.html
 */
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher04")
public class dispatcher04 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取上下文对象
		ServletContext sc = getServletContext();
		/*
		 *跳转html页面，注意一般写在WebContent中，与WEB-INF平级
		 *此时参数是：/网页名字
		 */
		sc.getRequestDispatcher("/show.html").forward(req, resp);
	}
}
