package c$ContextDispatcher;
/**
 * 	页面交互（跳转）--》从servletDemo01到servletDemo02
 * javaee用浏览器来区分用户的
 * servletContext域对象
 * 
 */
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher02")
public class dispatcher02 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取servletContext的值，这是在两个不同的servlet中
		ServletContext sc = getServletContext();
		System.out.println(sc);
		Object value = sc.getAttribute("name");
		System.out.println("name的value值是"+value);
		System.out.println("dispatcher02将跳转到dispatcher03");
		sc.getRequestDispatcher("/dispatcher03").forward(req, resp);
	}
	
}
