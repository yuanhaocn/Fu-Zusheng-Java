package httpSession.maxAge;

/**
 *  修改cdemo04
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sdemo05")
public class Invalidate_Set_Lifecycle extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session1 = req.getSession();
		// 销毁当前用户绑定的session
		System.out.println(session1+"   "+session1.getId());
		//这样做有隐患，不安全，修改之因为摧毁的是磁盘里面的序列化session对象，
		//已经被加载到内存里面的不能摧毁，所以结果是有可能没有效果
		
		session1.invalidate();
		HttpSession session2=req.getSession();
		System.out.println(session2+"   "+session2.getId());

		// 获取并打印
		System.out.println( session1+"等于    "+session2);
	}

}
