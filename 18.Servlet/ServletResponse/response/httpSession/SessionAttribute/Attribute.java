package httpSession.SessionAttribute;
/**

 * 	session的中文名称会话，在浏览器一次开启期间，对于当前服务器的多次访问
	(请求和响应)称为一次会话。在一次会话期间，只要不设置session生命周期，
	session将是唯一的，且永久有效。
	特别需要注意的是，关闭浏览器之后，服务器上的session对象并没有消失，我们
	可以通过技术手段找回上一次访问的session对象
	只要是在一次会话期间，无论是转发还是重定向，session域一直有效

   
         在session中获得域对象的值
 * 在session里面设置域对象的值
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sdemo08")
public class Attribute extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求域
		req.setAttribute("requestScope", "request");
		//设置session域
		req.getSession().setAttribute("sessionScope", "session");
		//设置上下文
		getServletContext().setAttribute("servletContextScope", "servletContext");
		//第一种选择：转发到sdemo09
		req.getRequestDispatcher("/sdemo09").forward(req, resp);
		//第二种选择：重定向到sdemo10
		//resp.sendRedirect("/ServletResponse/sdemo10");
	}

	
}
