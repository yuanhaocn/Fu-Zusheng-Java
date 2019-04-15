package httpSession.SessionAttribute;
/**
 *重定向之后 获得域对象的值
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sdemo10")
public class SendRedirect extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println(req.getAttribute("requestScope"));//这个是null
		//req.getSession().invalidate();//会将Session的域变为null
		System.out.println(req.getSession().getAttribute("sessionScope"));
		System.out.println(getServletContext().getAttribute("servletContextScope"));
	}

	
}
