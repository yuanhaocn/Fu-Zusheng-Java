package RequestDispatcher;
/**
 * void   removeAttribute(String name)       删除指定名称的域对象
 结论：
	只在一次请求中有效
	
 关于一次请求的解释：
	1）发送一次
	2）请求未被处理，一直处于转发状态，转发多少次，都是一次请求
	
作用域：
	1）在时间上讲，请求从客户端发出开始，到服务器处理为止，
		service方法执行完毕，或者是servlet中使用response对象做出响应
	2）在空间上讲，理论上只要一直转发，request的值可以一直存在下去
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

@WebServlet("/rdemo09")
public class DispatchedByServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 使用request对象获取值
		Object value = req.getAttribute("name");
		System.out.println(value);
	}
}