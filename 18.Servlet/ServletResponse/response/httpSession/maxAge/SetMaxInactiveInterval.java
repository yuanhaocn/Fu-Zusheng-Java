package httpSession.maxAge;
/**
setMaxInactiveInterval( );方法设置session的最大生命周期
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/sdemo03")
public class SetMaxInactiveInterval extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	//设置最大的生命周期
	 session.setMaxInactiveInterval(2100);//不注释掉会影响XML 的内容
	//获取并打印
	System.out.println(session.getMaxInactiveInterval());
	}
	
}
