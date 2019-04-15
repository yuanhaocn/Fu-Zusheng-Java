package URLRewrite;
/**
  	2.重定向的url复写
	代码：
		UrlDemo01 （进行url编码，并且重定向）
		UrlDemo02 （session的获取，禁用Cookie撞击后有效）
	结果：
		1）如果没有禁用cookie，依然采用cookie的方式
			如果禁用cookie就会url复写，url一般不推荐
		2）如果禁用了Cookie，转发或者重定向的session不再是同一个
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/udemo02")
public class URLDemo02 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		boolean b = session.isNew();
		//判断session是否是新建的
		System.out.println(b);
		System.out.println("udemo02获取的："+session.getId());
	}

}
