package httpSession.basis;
/**
 * 	String	getId()  获取session对象的id，也就是JSESSIONID这个cookie对象的value值
	long getLastAccessedTime()  获取该session对象的最后访问时间，因为session是弹性时间
	int	getMaxInactiveInterval()   获取最大生命周期，默认值是30min,返回值是秒
 */
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sdemo01")
public class SessionDemo01 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		//最新访问时间
		long lastAccessedTime = session.getLastAccessedTime();
		System.out.println("最后访问时间是"+new Date(lastAccessedTime));
		//获取当前session 的ID值
		String id = session.getId();
		System.out.println("session对象的ID属性值"+id);
		//获取当前生命周期
		int maxInactiveInterval = session.getMaxInactiveInterval();
		System.out.println("session对象的最大生命周期是"+maxInactiveInterval);
	}

	
}
