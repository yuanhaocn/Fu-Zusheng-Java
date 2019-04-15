package httpSession.basis;
/**
 * 每个web都继承Apache/conf/web.xml文件
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/SessionInstance")
public class SessionInstance extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//获取session对象，只能获取，不能创建，服务器创建，不是由客户创建
		HttpSession session = req.getSession();
	//查看session的ID的值
		String id = session.getId();
		System.out.println(id);
	}
	
}
