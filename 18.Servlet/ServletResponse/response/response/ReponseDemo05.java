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

@WebServlet("/rdemo05")
public class ReponseDemo05 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取默认编码方式
		String encoding = resp.getCharacterEncoding();
		System.out.println(encoding);
		//设置编码方式,有时候不好用，但是要加上，最好再加上resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().println("你好");
		System.out.println(resp.getCharacterEncoding());
	}
	
}
