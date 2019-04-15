package response;
/**
 * 获取响应消息头里面的信息 
 */
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo04")
public class SetDateHeader extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置一个响应消息头,标准时间不是东八区的，可以用candela获取
		resp.setDateHeader("Date", new Date().getTime());
		//根据名称获取响应消息头，会把cookie带进去
		String dateInfo = resp.getHeader("Date");
		System.out.println(dateInfo);
	}
	
}
