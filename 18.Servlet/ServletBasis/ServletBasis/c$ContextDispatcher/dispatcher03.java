package c$ContextDispatcher;
/**
 * 移除域对象的值
 */
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher03")
public class dispatcher03 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取servletContext的值，这是在两个不同的servlet中
		ServletContext sc = getServletContext();
		 //移除域对象的值
		System.out.println("移除name,name的value将是null");
		sc.removeAttribute("name");
	}
}
