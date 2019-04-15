package a$Create_Servlet_Method;
/**
 * 继承HttpServlet没有必须实现的类
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo03 extends HttpServlet {
		//重写doGet   和  doPost
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//浏览器里面输入网址的回车相当于超链接的点击   默认是get类型
			System.out.println("这是我们的get方法。。。");
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			super.doPost(req, resp);
		}
}
