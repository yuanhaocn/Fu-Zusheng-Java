package c$ContextDispatcher;
/**
 * 页面交互（跳转）--》从servlet到servlet,用注解的方式来代替XML配置  
 * 
 * dispatcher01设置一个域对象的值，name:fzs 
 * 然后跳转到dispatcher02，通过getServletContext的方法getAttribute获得name的value属性fzs，
 * 再跳转到dispatcher03通过getServletContext的方法removeAttribute对象移除name
 * 
 * 如果再次调用dispatcher02，将会得到空的value值，因为name的value值已经被dispatcher03移除了
 */
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher01")
public class dispatcher01 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		System.out.println(sc);
		//设置域对象的值
		sc.setAttribute("name", "fzs");
		/*
		 * 页面跳转到指定的servlet
		 * 
		 *参数：
		 *	是要跳转到servlet的urlparrent
		 *然后是forword方法
		 *参数：就是doGet方法的参数
		 */
		System.out.println("dispatcher01将跳转到dispatcher02");
		sc.getRequestDispatcher("/dispatcher02").forward(req, resp);
	}
}
