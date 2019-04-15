package httpSession.SessionAttribute;
/**
 * 转发之后 获得域对象的值
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sdemo09")
public class RequestDispatcher extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求域
		System.out.println(req.getAttribute("requestScope"));
		System.out.println(req.getSession().getAttribute("sessionScope"));
		System.out.println(getServletContext().getAttribute("servletContextScope"));
	}

	
}
