package httpSession.maxAge;

/**
 *  使用XML进行设置最大生命周期
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sdemo04")
public class XML_Set_Lifecycle extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		// 销毁当前用户绑定的session
		System.out.println(session.getId());
		//这样做有隐患，不安全，修改之,销毁的是磁盘里面的东西，而不是内存里面的，所以两次打印的id 是一样的，因为
		//它们都是在已经内存里面，
		session.invalidate();
		System.out.println(session.getId());
		// 获取并打印
		System.out.println(session.getMaxInactiveInterval());
	}

}
