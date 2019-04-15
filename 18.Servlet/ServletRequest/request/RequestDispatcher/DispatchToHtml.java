package RequestDispatcher;
/**
 * 请求转发，是一次请求服务器，服务器内部完成跳转
 * 因此地址栏不发生改变，但是可以访问目标资源
 * 
 * RequestDispatcher	getRequestDispatcher(String path)
	一般不是单独使用，需要在方法的返回值也就是RequestDispatcher对象后面
	调用forword方法，该方法的两个参数是request和response对象

 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo07")
public class DispatchToHtml extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("转发开始");
		// 请求转发方法
		req.getRequestDispatcher("/target.html").forward(req, resp);
		System.out.println("转发结束");
	}
}