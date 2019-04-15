package URLRewrite;
/**
 * url复写解决cookie的禁用问题（jsession会被放在地址栏里面传到servlet里面来）
 * 在浏览器禁用cookie的时候如何在servlet跳转中使用同一个session对象，
 * 以保证信息在不同的地方共享
 * 对转发的URL进行编码直接将session传到下一个servlet中去，下一个就不用创建新的session
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/udemo01")
public class URLDemo01 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//与要对重定向的URL进行编码，进行转发页面的加工,可以把jsessionid绑定到地址栏进行传输
		String encodeURL = resp.encodeRedirectUrl("/ServletResponse/udemo02");
		//获取session对象
		System.out.println("udemo01获取的："+session.getId());
		resp.sendRedirect(encodeURL);
	}
}
