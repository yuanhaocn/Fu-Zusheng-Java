package response.status;
/**
 *  
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo03")
public class GetStatus extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取当前的状态码,一般是200代表正常访问
		int status = resp.getStatus();
		System.out.println(status);
		//设置错误编码为404 500 502 暂时让用户无法访问下面的内容，自己慢慢修错误的内容
		resp.setStatus(404);
		System.out.println(3/0);
	}
}
